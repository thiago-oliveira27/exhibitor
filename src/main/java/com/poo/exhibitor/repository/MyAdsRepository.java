package com.poo.exhibitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poo.exhibitor.model.ProductModel;

public interface MyAdsRepository extends JpaRepository<ProductModel,Long> {
	
//	@Query("select a from produto a where a.userId = :userId")
//	public ProductModel findUserAds(@Param(value = "user_id") Long userId);
		
	//public ProductModel findByUserId(Long userId);

}



