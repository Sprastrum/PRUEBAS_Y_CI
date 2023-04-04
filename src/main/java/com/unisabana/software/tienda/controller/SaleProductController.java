package com.unisabana.software.tienda.controller;

import com.unisabana.software.tienda.model.SaleProduct;
import com.unisabana.software.tienda.service.SaleProductService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
public class SaleProductController {
    @Resource
    private SaleProductService service;

    @GetMapping("/saleProduct/allSalesProducts")
    public List<SaleProduct> allTransactions() {
        return service.findAll();
    }
}
