package com.ecommerce.microservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.microservice.entity.Product;




public interface ProductRepository extends JpaRepository<Product,Integer> {
	@Query("select p from Product p where p.productName like :productName")
	public Page<Product> ProductByNom(@Param("productName") String n, Pageable pageable);
}
