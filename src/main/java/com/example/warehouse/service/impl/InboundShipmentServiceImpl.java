package com.example.warehouse.service.impl;

import com.example.warehouse.dto.mapper.InboundShipmentMapper;
import com.example.warehouse.dto.request.InboundShipmentRequest;
import com.example.warehouse.dto.response.InboundShipmentResponse;
import com.example.warehouse.entity.InboundShipment;
import com.example.warehouse.entity.Product;
import com.example.warehouse.entity.WareHouse;
import com.example.warehouse.exceptions.WareHouseNotFindByIdException;
import com.example.warehouse.repository.InboundShipmentRepository;
import com.example.warehouse.repository.ProductRepository;
import com.example.warehouse.repository.WareHouseRepository;
import com.example.warehouse.service.contract.InboundShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InboundShipmentServiceImpl implements InboundShipmentService {

    @Autowired
    private InboundShipmentRepository inboundShipmentRepository;

    @Autowired
    private InboundShipmentMapper inboundShipmentMapper;

    @Autowired
    private WareHouseRepository wareHouseRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    @Override
    public InboundShipmentResponse receiveProductInWareHouse(InboundShipmentRequest request, String warehouseId) {
        Product product = productRepository.findById(request.productDetails().productId())
                .orElse(null);

        if (product == null) {
            product = inboundShipmentMapper.productToEntity(request.productDetails());
            product = productRepository.save(product);
        }

        WareHouse warehouse = wareHouseRepository.findById(warehouseId)
                .orElseThrow(() -> new WareHouseNotFindByIdException("Warehouse not found!"));

        InboundShipment inboundShipment = inboundShipmentMapper.toEntity(request, new InboundShipment());
        inboundShipment.setProduct(product);
        inboundShipment.setWareHouse(warehouse);
        inboundShipmentRepository.save(inboundShipment);
        return inboundShipmentMapper.toResponse(inboundShipment);
    }


}
