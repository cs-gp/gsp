package com.himalayanGeeks.carRental.interceptor;

import java.security.Principal;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.himalayanGeeks.carRental.serviceImpl.CustomUserDetailsService;


public class NoticeInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// System.out.println("Calling preHandle");
		return super.preHandle(request, response, handler);

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String userMessage = "Welcome to one of the most used car Rental service";

		Principal principal = request.getUserPrincipal();
		//System.out.println(principal.getName());
		if (principal != null) {
			if (request.isUserInRole("ROLE_ADMIN"))
				userMessage = "Welcome Admin";
			else
				userMessage = "Please select a car to book";
		}

		// System.out.println("Calling postHandle");
		//modelAndView.getModel()
		modelAndView.getModelMap().addAttribute("message", userMessage);
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// System.out.println("Calling afterCompletion");
		super.afterCompletion(request, response, handler, ex);
	}

}
