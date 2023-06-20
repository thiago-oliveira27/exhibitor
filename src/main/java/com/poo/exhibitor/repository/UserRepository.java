package com.poo.exhibitor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.exhibitor.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel,Long> {

	Optional<UserModel> findByEmail(String email);
}
