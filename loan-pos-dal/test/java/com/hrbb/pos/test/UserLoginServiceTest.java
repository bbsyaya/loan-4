package com.hrbb.pos.test;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.dao.TCreditApplyDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:dao-config/spring-context-dao.xml"})
public class UserLoginServiceTest {
	
	@Autowired
	private TCreditApplyDao tCreditApplyDao;
	
	@Test
	public void get(){
		Map<String, Object> map = Maps.newHashMap();
		tCreditApplyDao.selectSelective(map);
	}
	
	/*@Autowired
	@Qualifier("userLoginService")
	private HService uHService;
	
	@Autowired
	private TCreditApplyInfoMapper tCreditApplyInfoMapper;
	
	@Test
	public void userReg() throws Exception{
		HRequest hRequest = new HRequest();
		hRequest.setBizType("userRegisterLoan");
		Map<String, Object> map = hRequest.getProperties();
		map.put("loginName", "67");
		
		map.put("userName", "96");
		
		map.put("password", "123");
		
		map.put("cellPhone", "1532664664556");
		
		map.put("email", "song@sina.com");
		
		map.put("loginType", "1");
		
		 map.put("tel", "1234");
		 uHService.serve(hRequest);
		 
	}
	
	@Test
	public void userLogin() throws Exception{
		Map<String, Object> map = Maps.newHashMap();
		tCreditApplyInfoMapper.getCreditApply(map);
	}
	
	@Test
	public void userModifyPwd() throws Exception{
		
	}*/
}
