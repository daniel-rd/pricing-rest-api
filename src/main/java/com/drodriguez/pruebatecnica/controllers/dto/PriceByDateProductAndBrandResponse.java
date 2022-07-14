package com.drodriguez.pruebatecnica.controllers.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class PriceByDateProductAndBrandResponse {
    private Float price;
    private Integer productId;
    private Integer brandId;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
}
