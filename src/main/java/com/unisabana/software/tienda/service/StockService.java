package com.unisabana.software.tienda.service;

import com.unisabana.software.tienda.model.Stock;

import java.util.List;

public interface StockService {
    boolean save(Stock stock);

    Stock read(int id);

    boolean delete(int id);

    List<Stock> findAll();
}
