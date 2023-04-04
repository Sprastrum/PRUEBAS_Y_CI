package com.unisabana.software.tienda.service;

import com.unisabana.software.tienda.model.SaleProduct;

import java.util.List;

public interface SaleProductService {
    boolean save(SaleProduct saleProduct);

    SaleProduct read(int id);

    boolean delete(int id);

    List<SaleProduct> findAll();
}
