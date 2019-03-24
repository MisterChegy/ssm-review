package interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorController {
	@RequestMapping("/gotoTest")
	public String gotoTest(){
		System.out.println("正在测试拦截器，执行控制器的处理请求方法中");
		return "test";
	}
}
