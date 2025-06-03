package com.example.warehouse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "recked_block")
@Getter
@Setter
public class RakedBlock extends Block{

    @OneToMany(mappedBy = "rakedBlock")
    private List<Rack> rakes;
}
