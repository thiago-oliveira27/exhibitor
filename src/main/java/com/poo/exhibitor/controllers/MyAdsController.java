package com.poo.exhibitor.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.poo.exhibitor.model.ProductModel;
import com.poo.exhibitor.service.MyAdsService;

@Controller
public class MyAdsController {
	
	@Autowired
	private MyAdsService myAdsService;
		
	@GetMapping("/myAds")
	public ModelAndView myAdsView(HttpSession session) {
		List<ProductModel> productList = this.myAdsService.getMyAdsList((Long) session.getAttribute("userId"));
		ModelAndView mv = new ModelAndView("myAds");
		mv.addObject("productList", productList);
		
		if(productList.size()==0) {
			mv.addObject("noAdsYet","You don't have any ads yet.");
		}
		return mv;
	}
	
	@GetMapping("/myAds/delete/{id}")
	public String deleteAdd(@PathVariable("id") Long id){
		this.myAdsService.deleteMyAd(id);
		return "redirect:/myAds";
		
	}
	

	

}
