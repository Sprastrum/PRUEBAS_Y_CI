package com.unisabana.software.tienda.service;

import com.unisabana.software.tienda.model.Stock;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StockService {
    boolean save(Stock stock);

    Stock read(int id);

    boolean delete(int id);

    Stock findByID(int id);

    List<Stock> findAll();

    void setQuantity(int quantity, int id);
}