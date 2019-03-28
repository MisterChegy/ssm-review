package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbcTemplate.TransactionTemplateDao;

public class TransactionTemplateTest {
	public static void main(String[] args) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
		TransactionTemplateDao ct = (TransactionTemplateDao) appCon.getBean("transactionTemplateDao");
		String result = ct.test();
		System.out.println(result);
		
	}
}
