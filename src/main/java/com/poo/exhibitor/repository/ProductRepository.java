package com.poo.exhibitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.exhibitor.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel,Long> {

	
}
