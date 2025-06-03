package com.example.warehouse.service.contract;

import com.example.warehouse.dto.request.InboundShipmentRequest;
import com.example.warehouse.dto.response.InboundShipmentResponse;
import org.springframework.stereotype.Service;


public interface InboundShipmentService {




    InboundShipmentResponse receiveProductInWareHouse(InboundShipmentRequest request, String warehoueId);
}
