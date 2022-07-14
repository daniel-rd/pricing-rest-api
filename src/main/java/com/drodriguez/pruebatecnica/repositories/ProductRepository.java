package com.drodriguez.pruebatecnica.repositories;

import com.drodriguez.pruebatecnica.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
