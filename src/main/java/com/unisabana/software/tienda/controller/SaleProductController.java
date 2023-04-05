package com.unisabana.software.tienda.controller;

import com.unisabana.software.tienda.controller.dto.SaleProductDTO;
import com.unisabana.software.tienda.model.SaleProduct;
import com.unisabana.software.tienda.service.SaleProductService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/saleProduct/salesProductsByDocumentClient/{DOCUMENT_CLIENT}")
    public List<SaleProduct> transactionsByDocumentClient(@PathVariable("DOCUMENT_CLIENT") int documentClient) {
        return service.findByDocumentClient(documentClient);
    }

    @PostMapping("/saleProduct/saveSaleProduct")
    public SaleProduct saveSaleProduct(@RequestBody SaleProductDTO saleProductDTO) {
        if(service.limitTransaction(saleProductDTO.getSaleDTO().getDocumentClient(),
                saleProductDTO.getSaleDTO().getDateCreated()) &&
                saleProductDTO.getQuantity() <= saleProductDTO.getStockDTO().getQuantity()) {
            service.save(saleProductDTO.toModel());
        }

        return saleProductDTO.toModel();
    }


}
