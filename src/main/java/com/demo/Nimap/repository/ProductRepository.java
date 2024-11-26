package com.demo.Nimap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Nimap.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
