package com.unisabana.software.tienda.repository;

import com.unisabana.software.tienda.model.SaleProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleProductRepository extends JpaRepository<SaleProduct, Integer> {
}
