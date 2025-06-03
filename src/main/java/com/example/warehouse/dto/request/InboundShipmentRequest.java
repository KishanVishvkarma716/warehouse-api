package com.example.warehouse.dto.request;

import com.example.warehouse.entity.Product;
import com.example.warehouse.enums.ShipmentStatus;

public record InboundShipmentRequest(
        String sellerId,
        ProductRequest productDetails,
        int quantity,
        ShipmentStatus status

) { }
