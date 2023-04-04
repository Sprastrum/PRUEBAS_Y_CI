package com.unisabana.software.tienda.service.impl;

import com.unisabana.software.tienda.model.Stock;
import com.unisabana.software.tienda.repository.StockRepository;
import com.unisabana.software.tienda.service.StockService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    private StockRepository stockRepository;

    @Override
    public boolean save(Stock stock) {
        stockRepository.save(stock);
        return stockRepository.existsById(Math.toIntExact(stock.getId()));
    }

    @Override
    public Stock read(int id) {
        return stockRepository.getReferenceById(id);
    }

    @Override
    public boolean delete(int id) {
        stockRepository.deleteById(id);
        return !stockRepository.existsById(id);
    }

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }
}
