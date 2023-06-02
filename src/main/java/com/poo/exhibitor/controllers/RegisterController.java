package com.poo.exhibitor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poo.exhibitor.entity.Product;
import com.poo.exhibitor.service.ProductService;

@Controller
public class RegisterController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/register")
	public ModelAndView getList() {
		
		ModelAndView mv = new ModelAndView("register");
		List<Product> productList = this.productService.getProductList();
		mv.addObject("productlist",productList);
		return mv;
	}
	
	@PostMapping("/product/form/save")
	public String saveProduct(Product product, BindingResult result, RedirectAttributes redirect) {
		
		if(result.hasErrors()) {
			redirect.addFlashAttribute("mensagem","Verifique os campos obrigatórios");
			return "redirect:/product/form/add";
		}
		
		this.productService.save(product);
		
		return "redirect:/display";
	}
}
