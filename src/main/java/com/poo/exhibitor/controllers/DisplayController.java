package com.poo.exhibitor.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.poo.exhibitor.model.ProductModel;
import com.poo.exhibitor.service.ProductService;

@Controller
public class DisplayController {
	
	@Autowired
	private ProductService productService;
	
	private static String imagePath = "C:\\Users\\Thiago\\Documents\\imagens\\";
	
	@GetMapping("/display")
	public ModelAndView getList() {
		List<ProductModel> productList = this.productService.getProductList();
		ModelAndView mv = new ModelAndView("display");
		mv.addObject("productList", productList);
		return mv;
	}
	
	@GetMapping("/display/{image}")
	@ResponseBody
	public byte[] returnImage(@PathVariable("image") String img) {
		
		if(!img.equals(null) || img.trim().length()>0) {
			
			File imageFile = new File(imagePath+img); 
			try {
				return Files.readAllBytes(imageFile.toPath());
			}catch(IOException e){ 
				e.printStackTrace();
			}
		}
		return null;
	}
}
