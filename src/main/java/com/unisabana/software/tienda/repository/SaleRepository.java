package com.unisabana.software.tienda.repository;

import com.unisabana.software.tienda.controller.dto.SaleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<SaleDTO, Integer> {
}
