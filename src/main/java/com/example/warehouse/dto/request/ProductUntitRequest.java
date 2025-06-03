package com.example.warehouse.dto.request;

public record ProductUntitRequest(
        String location,
        InboundBatchRequest inBoundBatchRequest
) {
}
