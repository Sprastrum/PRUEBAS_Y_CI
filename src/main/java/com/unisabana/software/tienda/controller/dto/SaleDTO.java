package com.unisabana.software.tienda.controller.dto;

import com.unisabana.software.tienda.model.Sale;
import com.unisabana.software.tienda.model.SaleProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {
    private Integer id;
    private Date dateCreated;
    private Integer documentClient;
    private Integer totalAmount;
    private List<SaleProductDTO> saleProductDTOS = new ArrayList<>();

    public Sale toModel() {
        List<SaleProduct> saleProducts = new ArrayList<>();

        for(SaleProductDTO s: saleProductDTOS) {
            saleProducts.add(s.toModel());
        }

        return new Sale(this.id, this.dateCreated, this.documentClient, this.totalAmount, saleProducts);
    }
}