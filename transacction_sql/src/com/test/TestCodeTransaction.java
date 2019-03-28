package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbcTemplate.CodeTransaction;

/**
 * 测试基于底层API的编程式事务管理
 * @author Administrator
 *
 */
public class TestCodeTransaction {
	public static void main(String[] args) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
		CodeTransaction ct = (CodeTransaction) appCon.getBean("codeTransaction");
		String result = ct.test();
		System.out.println(result);
		
	}
}
