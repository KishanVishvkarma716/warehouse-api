package com.example.warehouse.dto.request;

public record ProductRequest(
        String productId,
        String title,
        double weight,
        double lenght,
        double width,
        double height,
        String materialType,
        String careInstruction,
        double productPrice
) {
}
