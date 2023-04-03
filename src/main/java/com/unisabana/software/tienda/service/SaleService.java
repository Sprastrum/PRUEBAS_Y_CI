package com.unisabana.software.tienda.service;

import com.unisabana.software.tienda.controller.dto.SaleDTO;

import java.sql.Date;
import java.util.List;

public interface SaleService {
    boolean saveSale(SaleDTO saleDTO);

    SaleDTO readSale(int id);

    boolean deleteSale(int id);

    boolean limitTransaction(int documentClient);

    List<SaleDTO> findByDocumentClient(int documentClient);

    List<SaleDTO> findAll();

    List<SaleDTO> findByDocumentClientAndDateCreated(int documentClient, Date valueOf);
}
