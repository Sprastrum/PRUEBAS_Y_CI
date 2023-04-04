package com.unisabana.software.tienda.service;

import com.unisabana.software.tienda.model.Stock;

import java.util.List;

public interface StockService {
    boolean saveStock(Stock stock);

    Stock readStock(int id);

    boolean deleteStock(int id);

    List<Stock> findAll();
}
