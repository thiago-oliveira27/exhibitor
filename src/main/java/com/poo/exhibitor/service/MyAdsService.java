package com.poo.exhibitor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poo.exhibitor.model.ProductModel;
import com.poo.exhibitor.repository.MyAdsRepository;

@Service
public class MyAdsService {

	@Autowired
	MyAdsRepository myAdsRepository;
	
	public List<ProductModel> getMyAdsList(Long userId){
		List<ProductModel> userAdsList = this.myAdsRepository.findUserAds(userId);
		return userAdsList;
	}
	
	@Transactional
	public void deleteMyAd(Long productId) {
		this.myAdsRepository.deleteAdById(productId);
	}
	
	public ProductModel findById(Long productId) {
		return this.myAdsRepository.findById(productId).get();
	}

	public void edit(Long id) {
		// TODO Auto-generated method stub
		
	}

}
