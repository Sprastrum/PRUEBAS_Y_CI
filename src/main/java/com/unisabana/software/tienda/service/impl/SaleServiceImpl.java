package com.unisabana.software.tienda.service.impl;

import com.unisabana.software.tienda.model.Sale;
import com.unisabana.software.tienda.repository.SaleRepository;
import com.unisabana.software.tienda.service.SaleService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@Component
@NoArgsConstructor
@AllArgsConstructor
public class SaleServiceImpl implements SaleService {
    @Resource
    private SaleRepository saleRepository;

    @Override
    public boolean save(Sale sale) {
        saleRepository.save(sale);
        return saleRepository.existsById(Math.toIntExact(sale.getId()));
    }

    @Override
    public Sale read(int id) {
        return saleRepository.getReferenceById(id);
    }

    @Override
    public boolean delete(int id) {
        saleRepository.deleteById(id);
        return !saleRepository.existsById(id);
    }

    @Override
    public boolean limitTransaction(int documentClient, Date date) {
        return saleRepository.limitTransactions(documentClient, date).size() < 3;
    }

    @Override
    public Sale findByID(int id) {
        return saleRepository.searchByID(id);
    }

    @Override
    public List<Sale> findByDocumentClient(int documentClient) {
        return saleRepository.searchByDocumentClient(documentClient);
    }

    @Override
    public List<Sale> findAll() {
        return saleRepository.findAll();
    }
}
