package com.poo.exhibitor.controllers;

import java.util.List;
import java.util.Optional;

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
			mv.addObject("noAdsYet","You have no ads yet.");
		}
		return mv;
	}
	
	@GetMapping("/myAds/delete/{id}")
	public String deleteAd(@PathVariable("id") Long id){
		this.myAdsService.deleteMyAd(id);
		return "redirect:/myAds";
		
	}
	
	@GetMapping("/myAds/edit/{id}")
	public ModelAndView editAd(@PathVariable("id") Long id, HttpSession session){
		
		ModelAndView mv = new ModelAndView("register"); 
		List<ProductModel> productList = this.myAdsService.getMyAdsList((Long) session.getAttribute("userId"));
		mv.addObject("productList", productList);
		
		ProductModel myProduct = this.myAdsService.findById(id) ;
		mv.addObject("myProduct", myProduct);
		return mv;
		
	}
	

	

}
