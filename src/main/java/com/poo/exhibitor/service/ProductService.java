package com.poo.exhibitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.poo.exhibitor.model.ProductModel;
import com.poo.exhibitor.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public List<ProductModel> getProductList(){
		Iterable<ProductModel> productIterable = this.productRepository.findAll();
		return Streamable.of(productIterable).toList();
	}
	
	public void save(ProductModel product) {
		this.productRepository.save(product);
	}

	
	public void getMessageData() {
		//this.productRepository.findDataToMessage(null);
	}
	
	public List<ProductModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
