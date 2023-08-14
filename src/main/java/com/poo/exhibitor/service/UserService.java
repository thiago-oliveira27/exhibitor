package com.poo.exhibitor.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.exhibitor.model.UserModel;
import com.poo.exhibitor.repository.UserRepository;
import com.poo.exhibitor.userExceptions.PasswordEncryptionException;
import com.poo.exhibitor.userExceptions.ServiceExc;
import com.poo.exhibitor.userExceptions.UserAlreadyExistsException;
import com.poo.exhibitor.util.UserUtil;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Boolean isValidUserName(UserModel user) throws UserAlreadyExistsException {
		if(userRepository.findByUsername(user.getUsername()) != null) {
			return false;
		}
		return true;
	}
	
	public void saveUser(UserModel user) throws Exception {
				
		try {
			
			user.setPassword(UserUtil.md5(user.getPassword()));

		} catch (NoSuchAlgorithmException e) {
			throw new PasswordEncryptionException("Error encrypting password");
		}
		
		userRepository.save(user);
	}
	
	public UserModel getUserLogin(String username, String password) throws ServiceExc {
		UserModel userLogin = userRepository.getUserLogin(username, password);
		return userLogin;
	}
	
	public Long getUserId(String username) {
		return userRepository.getIdByName(username);
	}

}
