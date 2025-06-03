package com.example.warehouse.repository;

import com.example.warehouse.entity.InboundBatch;
import com.example.warehouse.entity.InboundShipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InboundBatchRepository extends JpaRepository<InboundBatch,String> {
}
