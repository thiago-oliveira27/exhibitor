package com.poo.exhibitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.poo.exhibitor.model.ProductModel;

@Repository
@Transactional
public interface MyAdsRepository extends JpaRepository<ProductModel,Long> {
	
	@Query("SELECT p FROM produto p WHERE p.userId = :userId")
	public List<ProductModel> findUserAds(@Param(value = "userId") Long userId);

	@Modifying
	@Query("DELETE FROM produto p WHERE p.id = :id")
	public void deleteAdById(@Param(value="id") Long productId);


}



