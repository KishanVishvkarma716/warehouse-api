package com.example.warehouse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "rack")
@Inheritance(strategy = InheritanceType.JOINED)
public class Rack {

    @ManyToOne
    @JoinColumn(name = "raked_block_id")
    private RakedBlock rakedBlock;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String rackId;

    @Column(name = "height",nullable = false)
    private double height;

    @Column(name = "lenght",nullable = false)
    private double lenght;

    @Column(name = "widht",nullable = false)
    private  double widht;


}
