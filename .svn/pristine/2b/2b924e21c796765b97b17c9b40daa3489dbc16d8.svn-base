package com.hrbb.loan.pos.util;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *<h1>产生随机数工具类</h1>
 *@author Johnson Song
 *@version Id: RandomUtil.java, v 1.0 2015-2-26 上午11:13:40 Johnson Song Exp
 */
public class RandomUtil {
	
    private static Logger logger = LoggerFactory.getLogger(RandomUtil.class);
	
	public static String getRandom(int n){
		return (int) ((new Random(System.nanoTime()).nextDouble()
                ) * Math.pow(10, n))+"";
	}
	
	public static void main(String[] args) {
		
	    logger.debug(""+System.nanoTime());
	}
}
