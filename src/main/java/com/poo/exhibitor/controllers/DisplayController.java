package com.poo.exhibitor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DisplayController {


	 @GetMapping("/display") 
	 public ModelAndView getList() {
	  
	  //List<Product> productList = this.productService.findAll();
	  ModelAndView mv =  new ModelAndView("display");
	  //mv.addObject("productList",productList);
	  return mv;
	  
	  }
	 
}
