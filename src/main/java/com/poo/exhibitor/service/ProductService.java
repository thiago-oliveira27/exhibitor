package com.poo.exhibitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.poo.exhibitor.entity.Product;
import com.poo.exhibitor.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> getProductList(){
		Iterable<Product> productIterable = this.productRepository.findAll();
		return Streamable.of(productIterable).toList();
	}
	
	public void save(Product product) {
		this.productRepository.save(product);
	}
	
	/*
	 * public List<Product> findAll(){ return this.productRepository.findAll(); }
	 */
	
	
}
