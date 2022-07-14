package com.drodriguez.pruebatecnica.repositories;

import com.drodriguez.pruebatecnica.entities.Price;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;

@Repository
public interface PriceRepository extends PagingAndSortingRepository<Price,Integer> {
    @Query("SELECT p From Price p JOIN p.product pr JOIN p.brand br " +
            "WHERE p.startDate <= :sellDate " +
            "AND p.endDate >= :sellDate " +
            "AND pr.id = :productId " +
            "AND br.id = :brandId "
    )
    Page<Price> findPriceAndByDateProductAndBrand(@Param("sellDate")ZonedDateTime sellDate, @Param("productId")Integer productId, @Param("brandId")Integer brandId, Pageable p);
}
