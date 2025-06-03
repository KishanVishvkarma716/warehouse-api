package com.example.warehouse.dto.response;

import com.example.warehouse.entity.RakedBlock;
import com.example.warehouse.enums.BlockType;

public record RackResponse(
        String rackId,
        double height,
        double length,
        double breath

) {
}
