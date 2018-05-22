package br.com.opencare.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.templateresolver.ITemplateResolver;

import br.com.opencare.springdemo.config.SecurityConfiguration;

@Controller
public class HomeController {
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}


	@RequestMapping("/")
	public String splash() {
		if (SecurityConfiguration.getAuth().isAuthenticated())
			return "home";
		else
			return "splash";
	}
	
}
