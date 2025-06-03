package com.example.warehouse.dto.mapper;

import com.example.warehouse.dto.request.InboundShipmentRequest;
import com.example.warehouse.dto.request.ProductRequest;
import com.example.warehouse.dto.request.RackRequest;
import com.example.warehouse.dto.response.InboundShipmentResponse;
import com.example.warehouse.dto.response.ProductResponse;
import com.example.warehouse.entity.InboundShipment;
import com.example.warehouse.entity.Product;
import org.springframework.stereotype.Controller;

@Controller
public class InboundShipmentMapper {
   public InboundShipment toEntity(InboundShipmentRequest source , InboundShipment target){
       target.setSellerId(source.sellerId());
       target.setStatus(source.status());
       target.setQuantity(source.quantity());
       target.setProduct(productToEntity(source.productDetails()));
       return target;
   }

    public InboundShipmentResponse toResponse(InboundShipment inBoundShipment) {

        return new InboundShipmentResponse(
                inBoundShipment.getShipment_Id(),
                inBoundShipment.getSellerId(),
                inBoundShipment.getStatus(),
                inBoundShipment.getQuantity(),
                inBoundShipment.getCreatedAt().toEpochMilli(),
                productToResponse(inBoundShipment.getProduct())
        );
    }
    public Product productToEntity(ProductRequest productRequest) {

        Product product = new Product();
        product.setProductId(productRequest.productId());
        product.setTitle(productRequest.title());
        product.setWeight(productRequest.weight());
        product.setLenght(productRequest.lenght());
        product.setHeight(productRequest.height());
        product.setWidth(productRequest.width());
        product.setMaterialType(productRequest.materialType());
        product.setCareInstruction(productRequest.careInstruction());
        product.setPrice(productRequest.productPrice());

        return product;
    }
    private ProductResponse productToResponse(Product product) {

        return new ProductResponse(
                product.getProductId(),
                product.getTitle(),
                product.getWeight(),
                product.getLenght(),
                product.getHeight(),
                product.getWidth(),
                product.getMaterialType(),
                product.getCareInstruction(),
                product.getPrice()
        );
    }
}

