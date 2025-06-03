package com.example.warehouse.service.contract;

import com.example.warehouse.dto.request.InboundBatchRequest;
import com.example.warehouse.dto.response.InboundBatchResponse;

public interface InboundBatchService {
    InboundBatchResponse receiveProductUnit(InboundBatchRequest request, String shipmentId);

}
