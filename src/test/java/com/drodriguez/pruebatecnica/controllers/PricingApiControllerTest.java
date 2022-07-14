package com.drodriguez.pruebatecnica.controllers;

import com.drodriguez.pruebatecnica.controllers.dto.PriceByDateProductAndBrandResponse;
import com.drodriguez.pruebatecnica.exceptions.PriceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PricingApiControllerTest {

    @Autowired
    PricingApiController pricingApiController;

    @ParameterizedTest
    @CsvFileSource(resources = "/PricingApiTestInputOutput.csv", numLinesToSkip = 1, delimiter = ';')
    void test_getPriceByDateAndProductAndBrand_ok(Integer brandId, Integer productId, ZonedDateTime date, Float resultPrice) {
        PriceByDateProductAndBrandResponse result = pricingApiController.findPrioritaryPriceByDateAndProductIdAndBrandId(date, productId, brandId);
        assertThat(result).isNotNull();
        assertThat(result.getPrice()).isNotNull();
        assertThat(result.getBrandId()).isNotNull();
        assertThat(result.getProductId()).isNotNull();
        assertThat(result.getStartDate()).isNotNull();
        assertThat(result.getEndDate()).isNotNull();
        assertThat(result.getPrice()).isEqualTo(resultPrice);
    }

    @Test
    public void test_getPriceByDateAndProductAndBrand_notfound() {
        Exception exception = assertThrows(PriceNotFoundException.class,
                () -> pricingApiController.findPrioritaryPriceByDateAndProductIdAndBrandId(ZonedDateTime.now(), 1, 2));
        String expectedMessage = "Price not found with the given data";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
