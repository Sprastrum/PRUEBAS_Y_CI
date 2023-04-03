package com.unisabana.software.tienda.controller.dto;

import lombok.Data;

@Data
public class SaleProductDTO {
    private Integer id;
    private Integer product;
    private Integer quantity;
    private Integer saleID;
}
