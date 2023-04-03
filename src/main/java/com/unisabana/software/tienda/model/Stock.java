package com.unisabana.software.tienda.model;

import com.unisabana.software.tienda.controller.dto.SaleProductDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "STOCK")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, length = 10)
    private Integer id;

    @Column(name = "DATE_CREATED", nullable = false)
    private Date dateCreated;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "QUANTITY", nullable = false, length = 10)
    private Integer quantity;

    @Column(name = "VALUE", nullable = false, length = 10)
    private Integer value;

    @OneToMany
    private List<SaleProductDTO> saleProductDTOList;
}
