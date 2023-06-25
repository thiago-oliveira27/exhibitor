package com.poo.exhibitor.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.poo.exhibitor.model.UserModel;
import com.poo.exhibitor.repository.MyAdsRepository;

@Service
public class MyAdsService {

	@Autowired
	MyAdsRepository myAdsRepository;

	
}
