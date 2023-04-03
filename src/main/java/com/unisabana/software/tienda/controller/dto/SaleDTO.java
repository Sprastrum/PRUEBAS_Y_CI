package com.unisabana.software.tienda.controller.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class SaleDTO {
    private Integer id;
    private Date dateCreated;
    private Integer documentClient;
    private Integer totalAmount;
}
