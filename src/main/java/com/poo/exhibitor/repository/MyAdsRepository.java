package com.poo.exhibitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.exhibitor.model.ProductModel;

public interface MyAdsRepository extends JpaRepository<ProductModel,Long> {
	
//	@Query("select a from produto a where a.userId = :userId")
//	public ProductModel findUserAds(@Param(value = "user_id") Long userId);
		
	//public ProductModel findByUserId(Long userId);

}



