package interceptor.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler){
		System.out.println("preHandle方法在控制器的处理请求方法前执行");
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView)
			     throws Exception{
		System.out.println("postHandle 方法在控制器的处理请求方法调用之后，解析视图之前执行");
	}
	
	@Override		   
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex)
     throws Exception{
		System.out.println("afterCompletion 方法在控制器的处理请求方法执行完成后执行，即视图渲染结束之后执行");
	}
}
