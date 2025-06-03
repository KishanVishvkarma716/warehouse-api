package com.example.warehouse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="product_unit")
@Inheritance(strategy = InheritanceType.JOINED)
public class ProductUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name ="product_unit_id",nullable = false,updatable = false)
    private String unitId;

    @Column(name="location" ,length=2000)
    private String location;

    @ManyToOne
    @JoinColumn(name = "ibound_shipment_id")
    private InboundShipment inboundShipment;

    @ManyToOne
    @JoinColumn(name = "inbound_batch_id")
    private InboundBatch batch;

    @ManyToOne
    @JoinColumn(name = "ibound_batch")
    private InboundBatch inboundBatch;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
