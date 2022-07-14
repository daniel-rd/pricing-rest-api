package com.drodriguez.pruebatecnica.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Currency;

@Entity
@Data
@Table(name="PRICES")
public class Price {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name="START_DATE", columnDefinition = "TIMESTAMP",nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm:ss")
    private ZonedDateTime startDate;

    @Column(name="END_DATE", columnDefinition = "TIMESTAMP",nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm:ss")
    private ZonedDateTime endDate;

    @Column(nullable = false)
    private Integer priority;

    @Column(nullable = false)
    private Float price;

    @Column(name="CURR", nullable = false)
    private Currency currency;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false, foreignKey =@ForeignKey(name="price_product_fk"))
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id", nullable = false, foreignKey =@ForeignKey(name="price_brand_fk"))
    private Brand brand;
}
