package com.example.warehouse.service.impl;

import com.example.warehouse.repository.ProductRepository;
import com.example.warehouse.service.contract.ProductUnitSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductUnitImpl implements ProductUnitSrvice {

    @Autowired
    private ProductRepository productRepository;




}
