package com.example.warehouse.controller;


import com.example.warehouse.dto.request.InboundShipmentRequest;
import com.example.warehouse.dto.response.InboundShipmentResponse;
import com.example.warehouse.dto.wrapper.ResponseStructure;
import com.example.warehouse.service.contract.InboundShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InboundShipmentController {
    @Autowired
    private InboundShipmentService inboundShipmentService;

    @PostMapping("/receive/shipment/{warehouseId}")
    public ResponseEntity<ResponseStructure<InboundShipmentResponse>> receiveProductInWareHouse(@RequestBody InboundShipmentRequest request, @PathVariable String warehouseId){
        InboundShipmentResponse inboundShipmentResponse = inboundShipmentService.receiveProductInWareHouse(request,warehouseId);
        ResponseStructure<InboundShipmentResponse> responseStructure = new ResponseStructure<>(HttpStatus.CREATED.value(), "Product created in the warehosue",inboundShipmentResponse);
        return new ResponseEntity<ResponseStructure<InboundShipmentResponse>>(responseStructure,HttpStatus.CREATED);
    }
}
