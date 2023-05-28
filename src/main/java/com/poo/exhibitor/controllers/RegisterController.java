package com.poo.exhibitor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
	
	@GetMapping("/register")
	public ModelAndView getList() {
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}
}
