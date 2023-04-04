package com.unisabana.software.tienda.service;

import com.unisabana.software.tienda.model.SaleProduct;

import java.util.List;

public interface SaleProductService {
    boolean saveSaleProduct(SaleProduct saleProduct);

    SaleProduct readSaleProduct(int id);

    boolean deleteSaleProduct(int id);

    List<SaleProduct> findAll();
}
