package com.unisabana.software.tienda.service.impl;

import com.unisabana.software.tienda.model.SaleProduct;
import com.unisabana.software.tienda.repository.SaleProductRepository;
import com.unisabana.software.tienda.service.SaleProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleProductServiceImpl implements SaleProductService {
    @Resource
    private SaleProductRepository saleProductRepository;

    @Override
    public boolean save(SaleProduct saleProduct) {
        saleProductRepository.save(saleProduct);
        return saleProductRepository.existsById(Math.toIntExact(saleProduct.getId()));
    }

    @Override
    public SaleProduct read(int id) {
        return saleProductRepository.getReferenceById(id);
    }

    @Override
    public boolean delete(int id) {
        saleProductRepository.deleteById(id);
        return !saleProductRepository.existsById(id);
    }

    @Override
    public List<SaleProduct> findByDocumentClient(int documentClient) {
        return saleProductRepository.searchByDocumentClient(documentClient);
    }

    @Override
    public int findSaleID() {
        return 0;
    }

    @Override
    public List<SaleProduct> findAll() {
        return saleProductRepository.findAll();
    }
}