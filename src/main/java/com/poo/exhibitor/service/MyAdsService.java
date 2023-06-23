package com.poo.exhibitor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.exhibitor.model.ProductModel;
import com.poo.exhibitor.repository.MyAdsRepository;

@Service
public class MyAdsService {

	@Autowired
	MyAdsRepository myAdsRepository;
	
	
	
}
