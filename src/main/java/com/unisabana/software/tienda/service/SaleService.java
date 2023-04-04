package com.unisabana.software.tienda.service;

import com.unisabana.software.tienda.model.Sale;

import java.sql.Date;
import java.util.List;

public interface SaleService {
    boolean saveSale(Sale sale);

    Sale readSale(int id);

    boolean deleteSale(int id);

    boolean limitTransaction(int documentClient);

    List<Sale> findByDocumentClient(int documentClient);

    List<Sale> findAll();

    List<Sale> findByDocumentClientAndDateCreated(int documentClient, Date valueOf);
}
