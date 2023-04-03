package com.unisabana.software.tienda.controller;

import com.unisabana.software.tienda.controller.dto.SaleDTO;
import com.unisabana.software.tienda.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class SaleController {
    @Autowired
    private SaleService service;

    public SaleController(List<String> products) {
    }

    @PostMapping("/product/save")
    public void saveTransaction(@RequestBody SaleDTO saleDTO) {
        if(service.limitTransaction(saleDTO.getDocumentClient())) {
            service.saveSale(saleDTO);
        }
    }

    @GetMapping("/product/transactions")
    public List<SaleDTO> allTransactions() {
        return service.findAll();
    }

    @GetMapping("/product/transaction/searchbyid/{ID}")
    public List<SaleDTO> transactionSearchById(@PathVariable("ID") int documentClient) {
        return service.findByDocumentClient(documentClient);
    }
    @GetMapping("/product/transaction/validation/{ID}")
    public List <SaleDTO> Validation(@PathVariable("ID") int documentClient) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();
        //List <SaleDTO> sales = service.findByDocumentClientAndDateCreated(documentClient, Date.valueOf(today));
        //if (sales.size() > 3) {
          //  System.out.println("NO PUEDE COMPRAR MAS");
        //}
        //else{
          //  System.out.println("puede seguir comprando");
        //}
        return service.findByDocumentClientAndDateCreated(documentClient, Date.valueOf(today));
    }
}