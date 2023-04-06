package com.unisabana.software.tienda.controller;

import com.unisabana.software.tienda.controller.dto.ResponseDTO;
import com.unisabana.software.tienda.controller.dto.SaleDTO;
import com.unisabana.software.tienda.model.Sale;
import com.unisabana.software.tienda.service.SaleService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
public class SaleController {
    @Resource
    private SaleService service;

    @PostMapping("/sale/saveSale")
    public ResponseDTO saveSale(@RequestBody SaleDTO saleDTO) {
        if(service.limitTransaction(saleDTO.getDocumentClient(), saleDTO.getDateCreated())) {
            service.save(saleDTO.toModel());
            return new ResponseDTO("Se ha guardado exitosamente.");
        }

        return new ResponseDTO("No se ha guardado.");
    }

    @RequestMapping(value = "/sale/saveSaleListProducts", method = RequestMethod.POST)
    public List<ResponseDTO> saveSaleListProducts(@RequestBody List<SaleDTO> salesDTOS) {
        List<Sale> sales = new ArrayList<>();
        List<ResponseDTO> results = new ArrayList<>();

        for(SaleDTO s: salesDTOS) {
            if(service.limitTransaction(s.getDocumentClient(), s.getDateCreated())) {
                service.save(s.toModel());
                sales.add(s.toModel());
                results.add(new ResponseDTO("Se ha guardado exitosamente."));
            } else {
                results.add(new ResponseDTO("No se ha guardado."));
            }
        }

        return results;
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

    @GetMapping("/sale/searchID/{DOCUMENT_CLIENT}")
    public List<Sale> searchSaleID(@PathVariable("DOCUMENT_CLIENT") int documentClient) {
        return service.findByDocumentClient(documentClient);
    }


}