package br.com.opencare.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.opencare.springdemo.config.SecurityConfiguration;

@Controller
public class HomeController {
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}


	@RequestMapping("/")
	public String splash() {
		System.out.println(SecurityConfiguration.getAuth().getName());
		
		if (SecurityConfiguration.isFullyAuthenticated())
			return "home";
		else
			return "splash";
	}
	
}
