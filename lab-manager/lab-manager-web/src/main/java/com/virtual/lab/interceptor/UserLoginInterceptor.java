package com.virtual.lab.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.virtual.lab.pojo.TbUser;

/**
 * 自定义拦截器，实现用户未登录自动跳转到登录页面
 * @author xiaoqiang
 *
 */
public class UserLoginInterceptor implements HandlerInterceptor{

	private List<String> IGNORE_URI;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//获取URI后缀
        String requestUri = request.getServletPath();

        /*if(requestUri.equalsIgnoreCase("/"))    return true;*/

        //过滤不需要拦截的地址
        for (String uri : IGNORE_URI) {
            if (requestUri.startsWith(uri)) {
                return true;
            }
        }
		
		//判断用户是否登录，如果没有登录 重定向到登录页面 不放行
		//如果登录了 就放行
		
		TbUser user = (TbUser) request.getSession().getAttribute("loginUser");
		boolean loginAsVisitor = (boolean)request.getSession().getAttribute("visitor");
		if(user != null || loginAsVisitor){
			//不为空或者以访客的身份登录了，则放行
			return true;
		}else{
			//如果为空，则跳转到登录页面
			response.sendRedirect("/page/login");
		}
		return false;
		
		//URL:  http://localhost:8080/page/login
		//URI:  /page/login
		/*String requestURI = request.getRequestURI();
		
		if(!requestURI.contains("/login")){//请求的uri中如果不包含/login
			TbUser user = (TbUser) request.getSession().getAttribute("loginUser");
			if(user == null){
				//重定向到登录页面
				response.sendRedirect(request.getContextPath()+"/page/login");
				//不放行
				return false;
			}
		}
		//放行
		return true;*/
	}

	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public List<String> getIGNORE_URI() {
        return IGNORE_URI;
    }

    public void setIGNORE_URI(List<String> IGNORE_URI) {
        this.IGNORE_URI = IGNORE_URI;
    }

}
