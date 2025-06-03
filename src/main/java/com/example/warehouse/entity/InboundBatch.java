package com.example.warehouse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="inbound_batch")
public class InboundBatch {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name ="batch_Id",nullable = false,updatable = false)
    private String batchId;

    @Column(name = "Countof_rejected_units",nullable = false)
    private int countOfRejectedUnit;

    @Column(name = "Countof_accepted_units",nullable = false)
    private int countOfAcceptedUnit;

    @OneToMany(mappedBy = "batch")
    private List<ProductUnit> productUnits;

}
