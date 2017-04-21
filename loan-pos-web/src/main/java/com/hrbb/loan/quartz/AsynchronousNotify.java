/**
 * 
 */
package com.hrbb.loan.quartz;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.hrbb.loan.pos.dao.entity.TAsynchronousNotification;
import com.hrbb.loan.pos.factory.ConfigService;
import com.hrbb.loan.pos.factory.SysConfigFactory;
import com.hrbb.loan.pos.service.AsynchronousNotificationService;
import com.hrbb.sh.framework.HttpRequestSender;

/**
 * <p>Title: AsynchronousNotifyTask.java </p>
 * <p>Description: 本任务用于各渠道的通用异步任务推送,推送消息表为t_asynchronous_notification,通过status判断是否已经成功，计划通知时间控制是否纳入推送范围 </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Aug 30, 2015
 *
 * logs: 1. 
 */
@Component("asynchronousNotify")
public class AsynchronousNotify extends AbsQuartzJob{
	
	@Autowired
	private AsynchronousNotificationService asynchronousNotificationService;
	
	@Autowired
	private  HttpRequestSender requestsender;
	
	private Map<Integer,String> executeResult = Maps.newHashMap();
	
	@Override
	protected boolean initJob() throws Exception {
		logger.debug("推送异步消息开始...");
		return true;
	}

	@Override
	protected boolean processJob() throws Exception {
		ConfigService service = null;
		
		/*所有未推送的消息 + 之前推送失败的消息*/
		Map<String,Object> map = Maps.newHashMap();
		List<TAsynchronousNotification> tasks = asynchronousNotificationService.selectTodoList(map);
		
		for(TAsynchronousNotification task:tasks){
			service = SysConfigFactory.getInstance().getService(task.getChannel());
			if(service==null) {
				logger.error("渠道["+task.getChannel()+"]无可用的的消息推送服务配置");
				continue;
			}
			
			String applyChangeUrl = service.getPropertyValue("applyChangeUrl");	//更新专用url
			String messageUrl = service.getPropertyValue("messageUrl");			//通用url
			//没有专有url使用通用url
			String url = (applyChangeUrl==null || applyChangeUrl.trim().length()==0)?messageUrl:applyChangeUrl;
			String encryptedRender = service.getPropertyValue("encryptedRender");
			if(url==null || url.trim().length()==0
					|| encryptedRender==null || encryptedRender.trim().length()==0){
				logger.warn("渠道["+task.getChannel()+"]未配置正确的消息推送参数.");
				continue;
			}
			/*将DB中存放的JSON 字符串转换为JSON对象，并完成推送*/
			try{
				@SuppressWarnings("unchecked")
				Map<String,Object> msgContent = JSONObject.parseObject(task.getNotifyContent(), Map.class);		//防止json对象不完整
				
				String data = JSON.toJSONString(msgContent);
				logger.debug("发送给 "+task.getChannel()+" 的字符串为" + data);
				requestsender.sendEncryptedWithCompanion(messageUrl, data, encryptedRender);
				
				/*便于后续的状态更新*/
				executeResult.put(task.getId(), 任务执行状态_成功);
				
			}catch(Exception e){
				logger.error("异步消息推送失败.id="+task.getId()+" |channel="+task.getChannel(),e);
				/*便于后续的状态更新*/
				executeResult.put(task.getId(), 任务执行状态_失败);
			}
			
		}
		return true;
	}

	@Override
	protected boolean postJob() throws Exception {
		
		Iterator<Integer> keys = executeResult.keySet().iterator();
		while(keys.hasNext()){
			int id = keys.next();
			//推送状态:0-待推送;1-推送成功;9-推送失败
			String status = executeResult.get(id);
			if(status==null){
				logger.warn("id["+id+"]任务状态有误.");
				continue;
			}
			asynchronousNotificationService.updateSatusByPrimaryKey(status, id);
		}
		
		executeResult.clear();
		
		logger.debug("推送异步消息执行结束...");
		return true;
	}

	@Override
	public String getJobName() {
		return "异步消息通知";
	}
}
