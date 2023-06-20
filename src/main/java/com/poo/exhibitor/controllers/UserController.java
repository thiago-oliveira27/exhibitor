package com.poo.exhibitor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poo.exhibitor.model.UserModel;
import com.poo.exhibitor.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository; 
	
	@GetMapping("/")
    public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/login");
		return mv;
	}  

	@GetMapping("/cadastro")
    public ModelAndView cadastro() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", new UserModel());
		mv.setViewName("/cadastro");
		return mv;
	}
	
	@PostMapping
	private void saveUser(UserModel user){
		ModelAndView mv = new ModelAndView();
		userRepository.save(user);
		mv.setViewName("redirect:/login");
		
	}

}
