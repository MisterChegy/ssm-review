package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/login")
	public String login(){
		
		/**
		 * login代表逻辑视图名称，需要根据Spring MVC配置
		 * 文件中视图解析器的前缀和后缀找到对应的页面（物理视图）
		 */
		return "login";
	}
	@RequestMapping("/register")
	public String register(){
		return "register";
	}
}
