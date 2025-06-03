package com.example.warehouse.dto.request;

import com.example.warehouse.entity.ProductUnit;

import java.util.List;

public record InboundBatchRequest(
        int countOfRejectedUnit,
        int countOfAcceptedUnit

) {
}
