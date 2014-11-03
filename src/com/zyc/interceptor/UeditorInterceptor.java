package com.zyc.interceptor;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class UeditorInterceptor extends StrutsPrepareAndExecuteFilter {
	
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain){

		HttpServletRequest request = (HttpServletRequest) req;  

		       //不过滤的url  

		       String url = request.getRequestURI();  

		       if (url.endsWith(".jsp")) {  

		           try {

		chain.doFilter(req, res); 

		} catch (IOException e) {

		e.printStackTrace();

		} catch (ServletException e) {

		e.printStackTrace();

		}  

		       }else{  

		           try {

		super.doFilter(req, res, chain);//采用默认父类的拦截器，即 struts2 

		} catch (IOException e) {

		e.printStackTrace();

		} catch (ServletException e) {

		e.printStackTrace();

		}  

		       }  

		}

}
