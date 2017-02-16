package com.feitang.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;




public abstract class BaseController {
	protected Logger logger;
	public BaseController() {
		this.logger = LoggerFactory.getLogger(getClass());
	}
	
	public Map<String, String> getHeadersInfo() {
		HttpServletRequest request =  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	    Map<String, String> map = new HashMap<String, String>();
	    Enumeration<String> headerNames = request.getHeaderNames();
	    while (headerNames.hasMoreElements()) {
	        String key = (String) headerNames.nextElement();
	        String value = request.getHeader(key);
	        map.put(key, value);
	    }
	    return map;
	  }
	
	public String getDeviceToken(){
		return this.getHeadersInfo().get("devicetoken");
	}
	
	public String getAccessToken(){
		return this.getHeadersInfo().get("accesstoken");
	}
	
	public String getMemberNo(){
		return this.getHeadersInfo().get("membno");
	}
	
}
