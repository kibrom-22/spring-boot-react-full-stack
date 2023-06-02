package com.snva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snva.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
