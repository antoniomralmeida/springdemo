package br.com.opencare.springdemo.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.opencare.springdemo.model.SysUser;
import br.com.opencare.springdemo.repository.SysUserRepository;

@Controller
@RequestMapping(value = "/sysuser")
public class SysUserController {
	@Autowired
	SysUserRepository sysUserRepository;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	PasswordEncoder passwordEncoder;


	@GetMapping ("/new")
	public String edit( Model model) {
		model.addAttribute("sysUser", new SysUser());
		return "register";
	}

	@PostMapping("/new")
	public String save(@Valid SysUser sysUser, BindingResult result, Locale locale, Model model, RedirectAttributes ra) {
		if (result.hasErrors()) 
			return "register";
		try {
			sysUser.setPwd(passwordEncoder.encode(sysUser.getPwd()));
			sysUserRepository.save(sysUser);
		} catch (Exception e) {		
			result.addError(new ObjectError("sysUser" , messageSource.getMessage(e.getClass().getName(), null, locale)));
			return "register";
		}
		ra.addAttribute("message", "Sucesso!");
		return "redirect:/";
	}
}
