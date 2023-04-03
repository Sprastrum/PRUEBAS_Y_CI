package com.unisabana.software.tienda.repository;

import com.unisabana.software.tienda.controller.dto.StockDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockDTO, Integer> {
}
