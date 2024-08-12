package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "보안 홈페이지";
	}
	
	@RequestMapping("/admin/aHome")
	public String adminWelcome() {
		return "admin/adminWelcome";
	}
	
	@RequestMapping("/guest/gHome")
	public String guestWelcome() {
		return "guest/guestWelcome";
	}
	
	@RequestMapping("/member/mHome")
	public String memWelcome() {
		return "member/memWelcome";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "security/loginForm";
	}
	
	@RequestMapping("/loginError")
	public String loginError() {
		return "security/loginError";
	}
	

	
	
}
