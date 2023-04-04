package com.unisabana.software.tienda.service;

import com.unisabana.software.tienda.model.Sale;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public interface SaleService {
    boolean saveSale(Sale sale);

    Sale readSale(int id);

    boolean deleteSale(int id);

    boolean limitTransaction(int documentClient);

    List<Sale> findByDocumentClient(int documentClient);

    List<Sale> findAll();

    List<Sale> findByDocumentClientAndDateCreated(int documentClient, Date valueOf);
}
