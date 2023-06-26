package com.poo.exhibitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poo.exhibitor.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

//	@Query("SELECT u.username, p.nome, u.phoneNumber FROM ProductModel p LEFT JOIN p.user u WHERE p.id = :id")
//	List<Object[]> findDataToMessage(@Param("id") Long id);


}
