package com.example.warehouse.service.impl;

import com.example.warehouse.dto.mapper.RackMapper;
import com.example.warehouse.dto.request.RackRequest;
import com.example.warehouse.dto.response.RackResponse;
import com.example.warehouse.entity.Block;
import com.example.warehouse.entity.Rack;
import com.example.warehouse.entity.RakedBlock;
import com.example.warehouse.exceptions.BlockNotFoundException;
import com.example.warehouse.exceptions.UnSupportedBlockTypeException;
import com.example.warehouse.repository.BlockRepository;
import com.example.warehouse.repository.RackRepository;
import com.example.warehouse.service.contract.RackService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class RackServiceImpl implements RackService {

    @Autowired
    private RackRepository rackRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Autowired
    private RackMapper rackMapper;

    @Transactional
    @Override
    public RackResponse addRacks(RackRequest request ,String blockId){
        Block block = blockRepository.findById(blockId).orElseThrow(() -> new BlockNotFoundException("Block is NOT Exist") );
        Rack rack = rackMapper.toEntity(request,new Rack());
        if (block instanceof RakedBlock rakedBlock) {
            rack.setRakedBlock(rakedBlock);
            blockRepository.save(block);
            rackRepository.save(rack);
            return rackMapper.toResponse(rack);
        }
        else
            throw new UnSupportedBlockTypeException("Block must be Recked Type!!");
    }

}
