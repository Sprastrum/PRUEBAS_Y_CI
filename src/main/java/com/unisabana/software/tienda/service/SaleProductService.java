package com.unisabana.software.tienda.service;

import com.unisabana.software.tienda.model.SaleProduct;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public interface SaleProductService {
    boolean save(SaleProduct saleProduct);

    SaleProduct read(int id);

    boolean delete(int id);

    boolean limitTransaction(int documentClient, Date date);

    List<SaleProduct> findByDocumentClient(int documentClient);

    int findSaleID();

    List<SaleProduct> findAll();
}