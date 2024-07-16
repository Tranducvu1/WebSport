package com.example.SportWebFullStack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.SportWebFullStack.Config.AppConfig;

public class AuthInterceptor implements HandlerInterceptor{
	@Autowired
	public AuthInterceptor(AppConfig appConfig) {
	}
	
	

}
