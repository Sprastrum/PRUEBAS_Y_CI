package com.unisabana.software.tienda.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SALE_PRODUCT")
public class SaleProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 10) @Getter
    @Setter
    private Integer id;

    @Column(name = "PRODUCT", insertable = false, updatable = false, length = 10)
    @Getter
    @Setter
    private Integer product;
    @ManyToOne
    @JoinColumn(name = "PRODUCT")
    @Getter
    @Setter
    private Stock stock;

    @Column(name = "QUANTITY", length = 10)
    @Getter
    @Setter
    private Integer quantity;

    @Column(name = "SALE_ID", insertable = false, updatable = false, length = 10)
    @Getter
    @Setter
    private Integer saleID;
    @ManyToOne
    @JoinColumn(name = "SALE_ID")
    @Getter
    @Setter
    private Sale sale;
}
