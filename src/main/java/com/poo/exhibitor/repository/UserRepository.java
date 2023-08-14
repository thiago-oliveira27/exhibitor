package com.poo.exhibitor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poo.exhibitor.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {

	@Query("select u from user_tb u where u.username = :username")
	public UserModel findByUsername(@Param(value = "username") String userName);

	@Query("select u from user_tb u where u.username = :username and u.password = :password")
	public UserModel getUserLogin(@Param(value = "username")String username,@Param(value = "password") String password);

	@Query("SELECT u.user_id FROM user_tb u WHERE u.username = :username")
	public Long getIdByName(@Param("username") String username);

}
