package com.unisabana.software.tienda.repository;

import com.unisabana.software.tienda.controller.dto.SaleProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleProductRepository extends JpaRepository<SaleProductDTO, Integer> {
}
