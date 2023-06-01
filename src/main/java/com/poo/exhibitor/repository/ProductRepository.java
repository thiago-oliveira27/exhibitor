package com.poo.exhibitor.repository;

import org.springframework.data.repository.CrudRepository;

import com.poo.exhibitor.entity.Product;

public interface ProductRepository extends CrudRepository<Product,Long	> {

}
