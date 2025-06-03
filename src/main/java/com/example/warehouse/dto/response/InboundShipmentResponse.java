package com.example.warehouse.dto.response;

import com.example.warehouse.entity.Product;
import com.example.warehouse.enums.ShipmentStatus;

public record InboundShipmentResponse(
        String shipmentId,
        String sellerId,
        ShipmentStatus status,
        int quantity,
        long createdAt,
        ProductResponse productResponse

) { }
