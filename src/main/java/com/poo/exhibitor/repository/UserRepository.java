package com.poo.exhibitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poo.exhibitor.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel,Long> {

	@Query("select u from user_tb u where u.username = :username")
	public UserModel findByUsername(@Param(value = "username") String userName);

}
