package com.nareshit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nareshit.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {

}
