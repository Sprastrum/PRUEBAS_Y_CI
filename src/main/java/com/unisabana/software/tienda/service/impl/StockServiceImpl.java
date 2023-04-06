package com.unisabana.software.tienda.service.impl;

import com.unisabana.software.tienda.model.Stock;
import com.unisabana.software.tienda.repository.StockRepository;
import com.unisabana.software.tienda.service.StockService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@AllArgsConstructor
public class StockServiceImpl implements StockService {
    @Resource
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
    public Stock findByID(int id) {
        return stockRepository.searchByID(id);
    }

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public void setQuantity(int quantity, int id) {
        stockRepository.setQuantity(quantity, id);
    }
}
