package com.unisabana.software.tienda.controller;

import com.unisabana.software.tienda.controller.dto.StockDTO;
import com.unisabana.software.tienda.model.Sale;
import com.unisabana.software.tienda.model.Stock;
import com.unisabana.software.tienda.service.StockService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
public class StockController {
    @Resource
    private StockService service;

    @PostMapping("/stock/saveStock")
    public Stock saveStock(@RequestBody StockDTO stockDTO) {
        service.save(stockDTO.toModel());

        return stockDTO.toModel();
    }

    @GetMapping("/stock/allStocks")
    public List<Stock> allStocks() {
        return service.findAll();
    }

    @GetMapping("/stock/setQuantity/{QUANTITY}&{ID}")
    public void setQuantity(@PathVariable("QUANTITY") int quantity,
                             @PathVariable("ID") int id) {
        service.setQuantity(quantity, id);
    }
}
