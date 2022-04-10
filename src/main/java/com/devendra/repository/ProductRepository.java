package com.devendra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devendra.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
