package com.poo.exhibitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.exhibitor.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel,Long> {

}
