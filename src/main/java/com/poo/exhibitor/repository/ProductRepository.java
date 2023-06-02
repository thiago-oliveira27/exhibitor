package com.poo.exhibitor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.poo.exhibitor.entity.Product;

public interface ProductRepository extends CrudRepository<Product,Long	> {
	
	
	@Override
	List<Product> findAll();
}
