package com.example.warehouse.repository;

import com.example.warehouse.entity.Block;
import com.example.warehouse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
