/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.pos.loan.tools.database;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @author byp
 * @version $Id: LoanDatabase.java, v 0.1 2015年3月17日 下午6:22:46 byp Exp $
 */
public class LoanDatabase {

    private final static Logger logger = LoggerFactory.getLogger(LoanDatabase.class);
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config-tools.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            logger.error("数据库初始化失败!", (Throwable)e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

}
