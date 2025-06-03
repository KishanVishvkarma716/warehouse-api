package com.example.warehouse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "title",nullable = false)
    private  String title;

    @Column(name = "price",nullable = false)
    private  double price;

    @Column(name = "weight",nullable = false)
    private   double weight;

    @Column(name = "lenght",nullable = false)
    private  double lenght;

    @Column(name = "height",nullable = false)
    private  double height;

    @Column(name = "width",nullable = false)
    private  double width;

    @Column(name = "material_Type",nullable = false)
    private  String materialType;

    @Column(name = "care_isntruction",nullable = false)
    private  String careInstruction;

}
