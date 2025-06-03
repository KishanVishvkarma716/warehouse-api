package com.example.warehouse.dto.request;

import com.example.warehouse.entity.RakedBlock;

public record RackRequest(
        double height,
        double lenght,
        double width
) {
}
