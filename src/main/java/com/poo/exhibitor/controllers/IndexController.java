package com.poo.exhibitor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poo.exhibitor.model.UserModel;

@Controller
public class IndexController {
	
	@GetMapping("/index")
	public ModelAndView getList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index");
		mv.addObject("userModel", new UserModel());
		return mv;
	}
}
