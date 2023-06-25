package com.poo.exhibitor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poo.exhibitor.model.ProductModel;
import com.poo.exhibitor.repository.MyAdsRepository;
import com.poo.exhibitor.service.MyAdsService;

@Controller
public class MyAdsController {
	
	@Autowired
	MyAdsService myAdsService;
	
	@Autowired 
	MyAdsRepository myAdsRepository;
	
	@GetMapping("/myAds")
	public ModelAndView myAdsView() {
		ModelAndView mv = new ModelAndView("myAds");
		return mv;
	}


}
