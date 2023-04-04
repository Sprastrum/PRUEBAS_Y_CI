package com.unisabana.software.tienda.service.impl;

import com.unisabana.software.tienda.model.Sale;
import com.unisabana.software.tienda.repository.SaleRepository;
import com.unisabana.software.tienda.service.SaleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    @Resource
    private SaleRepository saleRepository;

    @Override
    public boolean saveSale(Sale sale) {
        saleRepository.save(sale);
        return saleRepository.existsById(Math.toIntExact(sale.getId()));
    }

    @Override
    public Sale readSale(int id) {
        return saleRepository.getReferenceById(id);
    }

    @Override
    public boolean deleteSale(int id) {
        saleRepository.deleteById(id);
        return !saleRepository.existsById(id);
    }

    @Override
    public boolean limitTransaction(int documentClient) {
        int transactionCount = 0;

        for(Sale s: saleRepository.findAll()) {
            if(s.getDocumentClient().equals(documentClient) && s.getDateCreated().getDay() == LocalDate.now().getDayOfMonth()) {
                transactionCount ++;
            }
        }

        return transactionCount <= 3;
    }

    @Override
    public List<Sale> findByDocumentClient(int documentClient) {
        List<Sale> sales = new ArrayList<>();

        for(Sale s: saleRepository.findAll()) {
            if(s.getDocumentClient().equals(documentClient)) {
                sales.add(s);
            }
        }

        return sales;
    }

    @Override
    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    @Override
    public List<Sale> findByDocumentClientAndDateCreated(int documentClient, Date valueOf) {
        return null;
    }
}
