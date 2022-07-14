package com.drodriguez.pruebatecnica.services;

import com.drodriguez.pruebatecnica.entities.Price;
import com.drodriguez.pruebatecnica.repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Optional;

@Service
public class PriceService {

    @Autowired
    PriceRepository priceRepository;

    public Optional<Price> findPrioritaryPriceByDateAndProductIdAndBrandId(ZonedDateTime sellDate, Integer productId, Integer brandId){
        PageRequest pageFirstByPriorityDesc = PageRequest.of(0, 1, Sort.by("priority").descending());
        Page<Price> pricePage = priceRepository.findPriceAndByDateProductAndBrand(sellDate, productId, brandId, pageFirstByPriorityDesc);
        return pricePage.stream().findFirst();
    }
}
