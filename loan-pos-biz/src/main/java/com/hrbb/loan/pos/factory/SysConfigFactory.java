/**
 * 
 */
package com.hrbb.loan.pos.factory;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.util.PropertyUtils;
import com.hrbb.loan.pos.util.xml.Document;
import com.hrbb.loan.pos.util.xml.Element;

/**
 * <p>Title: SysConfigService.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Aug 25, 2015
 *
 * logs: 1. 
 */
public class SysConfigFactory {
	
	private Logger logger = LoggerFactory.getLogger(SysConfigFactory.class);
	
	private String configFile = "sys-config-service.xml";
	//properties file
	private String propertiesFile = "config/properties/systemInfo.properties";
	
	private Map<String,ConfigService> servicePool = Maps.newHashMap();
	
	private volatile static SysConfigFactory services = null;
	
	public static SysConfigFactory getInstance(){
		if(services == null){
			synchronized (SysConfigFactory.class){
				if(services == null){
					services = new SysConfigFactory();
				}
			}
		}
		return services;
	}
	
	private SysConfigFactory(){
		try {
			String defaultPath = this.getClass().getClassLoader().getResource("config/etc").toURI().getPath();
			
			/*外化配置文件路径*/
			String basePath = PropertyUtils.getProperty("cfgFilePath", propertiesFile);
			if(basePath==null || basePath.trim().length()==0){
				/*配置文件路径*/
				basePath = defaultPath;
				logger.debug("系统配置文件采用[默认路径].");
			}else{
				//错误路径处理
				File cfgPath = new File(basePath);
				if(!cfgPath.exists() || !cfgPath.isDirectory()) {
					basePath = defaultPath;
					logger.debug("系统配置文件采用[默认路径].");
				}
			}
			if(!basePath.endsWith("/") && !basePath.endsWith("\\")){
				basePath += "/";
			}

			basePath += configFile;
			File cfgFile = new File(basePath);		//config file exist
			if(!cfgFile.exists()){
				basePath = defaultPath+configFile;	//overwrite path
//				logger.debug("初始化系统配置文件[默认路径]: "+configFile);
				logger.debug("系统配置文件采用[默认路径].");
			}
			logger.debug("初始化系统配置: "+configFile);
			
			/*读取service*/
			Document document = new Document(basePath);
			
			Element root = document.getRootElement();
			if(root==null){
				logger.warn(configFile+" 配置有误.");
				return ;
			}
			
			Element node = null;
			Iterator<?> iterator = root.getChildren("service").iterator();
			while(iterator.hasNext()){
				node = (Element)iterator.next();
				String serviceName = node.getChildTextTrim("name");
				String serviceLabel = node.getChildTextTrim("label");
				if(serviceName==null || serviceName.trim().length()==0){
					logger.warn(configFile+" 存在缺失name属性的service节点");
					continue;
				}
				ConfigService service = new ConfigService(serviceName,serviceLabel);
				
				Element xProps = node.getChild("properties");
				if(xProps!=null){
					Iterator<?> tk = xProps.getChildren("property").iterator();
					while(tk.hasNext()){
						Element xProp = (Element)tk.next();
						String n = xProp.getAttributeValue("name");
						String v = xProp.getAttributeValue("value");
						service.addProperty(n, v);
					}
					//add group 
					Iterator<?> gp = xProps.getChildren("group").iterator();
					while(gp.hasNext()){
						Element subProp = (Element)gp.next();
						String name = subProp.getAttributeValue("name");
						/*new group*/
						PropertyGroup group = new PropertyGroup(name);
						
						Iterator<?> sub = subProp.getChildren("property").iterator();
						while(sub.hasNext()){
							Element xSub = (Element)sub.next();
							String n = xSub.getAttributeValue("name");
							String v = xSub.getAttributeValue("value");
							group.addProperty(n, v);
						}
						service.addGroup(group);
					}
				}
//				logger.info(service.toString());
				servicePool.put(service.getName(), service);
			}
			logger.info("初始化系统配置文件完成.");
		} catch (Exception e) {
			logger.warn("系统配置文件初始化失败!",e);
		}
		
	}
	
	public ConfigService getService(String name){
		return servicePool.get(name);
	}
	
	public boolean hasService(String name){
		return servicePool.containsKey(name);
	}
	
//	public static final void main(String[] arge){
//		SysConfigFactory.getInstance();
//	}
}
