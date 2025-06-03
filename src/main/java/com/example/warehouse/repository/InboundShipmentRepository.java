package com.example.warehouse.repository;

import com.example.warehouse.entity.InboundShipment;
import com.example.warehouse.entity.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InboundShipmentRepository extends JpaRepository<InboundShipment,String> {
}
