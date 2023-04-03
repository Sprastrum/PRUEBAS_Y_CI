package com.unisabana.software.tienda.service.impl;

import com.unisabana.software.tienda.controller.dto.SaleDTO;
import com.unisabana.software.tienda.repository.SaleRepository;
import com.unisabana.software.tienda.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleRepository saleRepository;

    @Override
    public boolean saveSale(SaleDTO saleDTO) {
        saleRepository.save(saleDTO);
        return saleRepository.existsById(Math.toIntExact(saleDTO.getId()));
    }

    @Override
    public SaleDTO readSale(int id) {
        return saleRepository.getReferenceById(id);
    }

    @Override
    public boolean deleteSale(int id) {
        saleRepository.deleteById(id);
        return !saleRepository.existsById(id);
    }

    @Override
    public boolean limitTransaction(int documentClient) {
        boolean result;
        int transactionCount = 0;

        for(SaleDTO s: saleRepository.findAll()) {
            if(s.getDocumentClient().equals(documentClient) && s.getDateCreated().getDay() == LocalDate.now().getDayOfMonth()) {
                transactionCount ++;
            }
        }

        return transactionCount <= 3;
    }

    @Override
    public List<SaleDTO> findByDocumentClient(int documentClient) {
        List<SaleDTO> sales = new ArrayList<>();

        for(SaleDTO s: saleRepository.findAll()) {
            if(s.getDocumentClient().equals(documentClient)) {
                sales.add(s);
            }
        }

        return sales;
    }

    @Override
    public List<SaleDTO> findAll() {
        return saleRepository.findAll();
    }

    @Override
    public List<SaleDTO> findByDocumentClientAndDateCreated(int documentClient, Date valueOf) {
        return null;
    }
}
