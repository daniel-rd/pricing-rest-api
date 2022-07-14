package com.drodriguez.pruebatecnica.repositories;

import com.drodriguez.pruebatecnica.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
