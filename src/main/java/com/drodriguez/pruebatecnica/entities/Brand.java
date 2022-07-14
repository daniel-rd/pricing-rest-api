package com.drodriguez.pruebatecnica.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="BRANDS")
public class Brand {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name="NAME")
    private String name;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @OneToMany(mappedBy = "brand",cascade = CascadeType.REMOVE, fetch= FetchType.LAZY)
    private List<Price> brandPrices;
}
