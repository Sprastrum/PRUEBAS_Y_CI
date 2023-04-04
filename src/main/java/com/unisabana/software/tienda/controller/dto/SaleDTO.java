package com.unisabana.software.tienda.controller.dto;

import com.unisabana.software.tienda.model.Sale;
import lombok.Data;

import java.sql.Date;

@Data
public class SaleDTO {
    private Integer id;
    private Date dateCreated;
    private Integer documentClient;
    private Integer totalAmount;

    public Sale toModel() {
        return new Sale(this.id, this.dateCreated, this.documentClient, this.totalAmount, null);
    }
}
