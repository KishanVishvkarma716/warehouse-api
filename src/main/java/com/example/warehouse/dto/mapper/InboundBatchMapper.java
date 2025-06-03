package com.example.warehouse.dto.mapper;


import com.example.warehouse.dto.request.InboundBatchRequest;
import com.example.warehouse.dto.response.InboundBatchResponse;
import com.example.warehouse.dto.response.InboundShipmentResponse;
import com.example.warehouse.entity.InboundBatch;
import org.springframework.stereotype.Controller;

@Controller
public class InboundBatchMapper {

    public InboundBatch toEntity(InboundBatchRequest source, InboundBatch target){
        if (source == null) return null;
        target.setCountOfRejectedUnit(source.countOfRejectedUnit());
        target.setCountOfAcceptedUnit(source.countOfAcceptedUnit());
        return target;
    }

    public InboundBatchResponse toResponse(InboundBatch batch){
        if (batch == null) return null;
        return new InboundBatchResponse(
                batch.getBatchId(),
                batch.getCountOfRejectedUnit(),
                batch.getCountOfAcceptedUnit()
        );
    }
}