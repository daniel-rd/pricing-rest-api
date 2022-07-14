package com.drodriguez.pruebatecnica.controllers;

import com.drodriguez.pruebatecnica.controllers.dto.PriceByDateProductAndBrandResponse;
import com.drodriguez.pruebatecnica.entities.Price;
import com.drodriguez.pruebatecnica.exceptions.PriceNotFoundException;
import com.drodriguez.pruebatecnica.services.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/pricing")
@Log4j2
@Tag(name="Pricing Controller", description="Exposes APIs to obtain information about the pricing of Products for each Brand")
public class PricingApiController {

    @Autowired
    private PriceService priceService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(path="/findPriceByDateProductAndBrand", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Operation(summary = "Returns the price of a Product for a Brand in a given Date with the highest priority")
    @ApiResponse(responseCode = "200", description = "Returns the price, brand and product IDs, and start and end dates in which the price applies")
    @ApiResponse(responseCode = "404", description = "No price matches the criteria", content = @Content)
    public PriceByDateProductAndBrandResponse findPrioritaryPriceByDateAndProductIdAndBrandId(
            @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)ZonedDateTime sellDate,
            @RequestParam Integer productId,
            @RequestParam Integer brandId
            ){
        log.info("Received findPriceByDateProductAndBrand with timestamp {} productId {} and brand {}", sellDate,productId, brandId);
        Optional<Price> priceOptional = priceService.findPrioritaryPriceByDateAndProductIdAndBrandId(sellDate,productId, brandId);
        if(priceOptional.isEmpty()){
            log.error("Could not find Price with the given input");
            throw new PriceNotFoundException();
        }
        log.info("Found price data");
        return modelMapper.map(priceOptional.get(), PriceByDateProductAndBrandResponse.class);
    }
}
