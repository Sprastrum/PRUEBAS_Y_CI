package com.unisabana.software.tienda.controller.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StockDTO {
    private Integer id;
    private Date dateCreated;
    private String name;
    private Integer quantity;
    private Integer unitValue;
}
