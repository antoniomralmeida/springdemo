package br.com.opencare.springdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.opencare.springdemo.model.SysUser;
import br.com.opencare.springdemo.repository.SysUserRepository;

@Controller
@RequestMapping(value = "/sysuser")
public class SysUserController {
	@Autowired
	SysUserRepository sysUserRepository;

	@GetMapping ("/new")
	public ModelAndView edit( SysUser sysUser) {
		return new ModelAndView("register").addObject("sysUser", sysUser);
	}

	@PostMapping("/new")
	public ModelAndView save(@Valid SysUser sysUser, BindingResult result) {
		if (result.hasErrors()) 
			return edit(sysUser);
		sysUserRepository.save(sysUser);
		return new ModelAndView("redirect:/");
	}
}
