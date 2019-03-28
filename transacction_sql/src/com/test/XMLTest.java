package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.statement.controller.StatementController;

public class XMLTest {	
	public static void main(String[] args) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("statementapplicationContext.xml");
		StatementController ct = (StatementController) appCon.getBean("statementController");
		String result = ct.test();
		System.out.println(result);
		
	}
}
