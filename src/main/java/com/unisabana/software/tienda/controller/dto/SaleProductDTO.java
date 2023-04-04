package com.unisabana.software.tienda.controller.dto;

import com.unisabana.software.tienda.model.SaleProduct;
import lombok.Data;

@Data
public class SaleProductDTO {
    private Integer id;
    private Integer product;
    private StockDTO stockDTO;
    private Integer quantity;
    private Integer saleID;
    private SaleDTO saleDTO;

    public SaleProduct toModel() {
        return new SaleProduct(this.id, this.product, this.stockDTO.toModel(), this.quantity, this.saleID,
                this.saleDTO.toModel());
    }
}
