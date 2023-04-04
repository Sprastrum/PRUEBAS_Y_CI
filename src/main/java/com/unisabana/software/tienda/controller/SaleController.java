package com.unisabana.software.tienda.controller;

import com.unisabana.software.tienda.controller.dto.SaleDTO;
import com.unisabana.software.tienda.model.Sale;
import com.unisabana.software.tienda.service.SaleService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
public class SaleController {
    @Resource
    private SaleService service;

    @PostMapping("/sale/saveSale")
    public Sale saveSale(@RequestBody SaleDTO saleDTO) {
        if(service.limitTransaction(saleDTO.getDocumentClient(), Date.valueOf(LocalDate.now()))) {
            service.save(saleDTO.toModel());
        }

        return saleDTO.toModel();
    }

    @GetMapping("/sale/allSales")
    public List<Sale> allSales() {
        return service.findAll();
    }

    @GetMapping("/sale/searchByID/{ID}")
    public Sale saleSearchById(@PathVariable("ID") int id) {
        return service.findByID(id);
    }

    @GetMapping("/sale/searchByDocumentClient/{DOCUMENTCLIENT}")
    public List<Sale> saleSearchByDocumentClient(@PathVariable("DOCUMENTCLIENT") int documentClient) {
        return service.findByDocumentClient(documentClient);
    }
}