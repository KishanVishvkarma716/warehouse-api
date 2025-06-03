package com.example.warehouse.entity;

import com.example.warehouse.enums.ShipmentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "in_bound_shipment")
public class InboundShipment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "shipment_id",nullable = false,updatable = false)
    private  String shipment_Id;

     @Column(name = "status",nullable = false)
     private ShipmentStatus status;

    @Column(name = "quantity",nullable = false)
    private  int quantity;

    @CreatedDate
   @Column(name = "created_at", nullable = false,updatable = false)
    private Instant createdAt;

    @Column(name = "sellerId",nullable = false)
    private  String sellerId;

    @ManyToOne
    @JoinColumn (name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn (name = "warehouseId")
    private WareHouse wareHouse;
}
