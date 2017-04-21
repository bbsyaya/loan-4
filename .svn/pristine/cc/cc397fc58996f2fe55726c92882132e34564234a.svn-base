package com.hrbb.loan.pos.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author LFG
 * @version
 */
public class PropertyUtils {

    /**
     * 应用属性文件.
     */
    public static final String APPLICATION = "application.properties";

    private static ConcurrentHashMap<String, Properties> pool = new ConcurrentHashMap<String, Properties>();

    private static Properties init(String file) {
        try {
            InputStream in = PropertyUtils.class.getClassLoader().getResourceAsStream(file);
            Properties prop = new Properties();
            prop.load(in);
            Properties temp = pool.putIfAbsent(file, prop);
            if (temp == null) {
                return prop;
            }
            return temp;
        } catch (Exception e) {
            throw new RuntimeException("读取properties文件失败");
        }
    }

    public static String getProperty(String key, String file) {
        if (pool.containsKey(file)) {
            return (String) pool.get(file).get(key);
        } else {
            return (String) init(file).get(key);
        }
    }
    
    public static void createFile(String filePath,String content){
    	BufferedWriter bw =null;
    	try {
			File file = new File(filePath);
			if(!file.getParentFile().exists()){
				file.getParentFile().mkdirs();
			}
			if(file.exists()){
				file.delete();
			}
			file.createNewFile();
			if(!StringUtils.isBlank(content)){
				bw = new BufferedWriter(new FileWriter(file));
				bw.write(content);
				bw.flush();
			}
		} catch (Exception e) {
			throw new RuntimeException("创建Properties文件异常,"+e);
		}finally{
			if(null!=bw){
				try {
					bw.close();
				} catch (IOException e) {
					throw new RuntimeException("文件流关闭异常");
				}
			}
		}
	
    }
}
