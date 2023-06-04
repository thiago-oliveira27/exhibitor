package com.poo.exhibitor.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poo.exhibitor.entity.Product;
import com.poo.exhibitor.repository.ProductRepository;
import com.poo.exhibitor.service.ProductService;

@Controller
public class RegisterController {
	
	@Autowired
	private ProductRepository productRepository;
	
	private static String imagePath = "C:\\Users\\Thiago\\Documents\\imagens\\";
	
	@GetMapping("/register")
	public ModelAndView getList(Product product) {
		
		ModelAndView mv = new ModelAndView("register");
		//List<Product> productList = this.productService.getProductList();
		//mv.addObject("productList",productList);
		return mv;
	}
	
	@PostMapping("/product/form/save")
	public ModelAndView saveProduct(@Valid Product product, BindingResult result, 
							  RedirectAttributes redirect, @RequestParam("file") MultipartFile archive) {
		
		if(result.hasErrors()) {
			redirect.addFlashAttribute("mensagem","Verifique os campos obrigatórios");
			return getList(product);
		}
		
		productRepository.saveAndFlush(product);
		
		try {
			if(!archive.isEmpty()) {
				byte[] bytes = archive.getBytes();
				
				Path path = Paths.get(imagePath+String.valueOf(product.getId())+archive.getOriginalFilename());
				Files.write(path, bytes);
				
				product.setImageName(String.valueOf(product.getId())+archive.getOriginalFilename());
				productRepository.saveAndFlush(product);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return getList(new Product());
	}
}
