package com.unisabana.software.tienda.model;

import com.unisabana.software.tienda.controller.dto.SaleDTO;
import com.unisabana.software.tienda.controller.dto.StockDTO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "SALE_PRODUCT")
public class SaleProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 10)
    private Integer id;

    @Column(name = "PRODUCT", insertable = false, updatable = false, length = 10)
    private Integer product;
    @ManyToOne
    @JoinColumn(name = "PRODUCT")
    private StockDTO stockDTO;

    @Column(name = "QUANTITY", length = 10)
    private Integer quantity;

    @Column(name = "SALE_ID", insertable = false, updatable = false, length = 10)
    private Integer saleID;
    @ManyToOne
    @JoinColumn(name = "SALE_ID")
    private SaleDTO saleDTO;
}
