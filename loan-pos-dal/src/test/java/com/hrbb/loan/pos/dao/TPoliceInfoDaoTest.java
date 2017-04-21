package com.hrbb.loan.pos.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hrbb.loan.pos.util.JsonUtil;

/**
 * @author zhangwei5@hrbb.com.cn
 * @date 2015年9月24日下午3:36:27 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dao-config/spring-context-dao.xml"})
public class TPoliceInfoDaoTest {
    
    @Autowired
    @Qualifier("tPoliceInfoDao")
    private TPoliceInfoDao policeInfoDao;

    @Test
    public void test() {
        System.out.println("policeInfo :"+JsonUtil.toJson(policeInfoDao.selectByLoanId("LO2015092213225764298248032600")));
    }

}
