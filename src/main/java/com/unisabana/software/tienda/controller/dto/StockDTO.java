package com.unisabana.software.tienda.controller.dto;

import com.unisabana.software.tienda.model.SaleProduct;
import com.unisabana.software.tienda.model.Stock;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class StockDTO {
    private Integer id;
    private Date dateCreated;
    private String name;
    private Integer quantity;
    private Integer unitValue;
    private List<SaleProductDTO> saleProductDTOS = new ArrayList<>();

    public Stock toModel() {
        List<SaleProduct> saleProducts = new ArrayList<>();

        for(SaleProductDTO s: saleProductDTOS) {
            saleProducts.add(s.toModel());
        }

        return new Stock(this.id, this.dateCreated, this.name, this.quantity, this.unitValue, saleProducts);
    }
}
