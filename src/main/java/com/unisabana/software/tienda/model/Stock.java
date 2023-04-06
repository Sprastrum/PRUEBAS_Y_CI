package com.unisabana.software.tienda.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STOCK")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 10)
    @Getter
    @Setter
    private Integer id;

    @Column(name = "DATE_CREATED")
    @Getter
    @Setter
    private Date dateCreated;

    @Column(name = "NAME", length = 100)
    @Getter
    @Setter
    private String name;

    @Column(name = "QUANTITY", length = 10)
    @Getter
    @Setter
    private Integer quantity;

    @Column(name = "UNIT_VALUE", length = 10)
    @Getter
    @Setter
    private Integer unitValue;

    @OneToMany
    @ToString.Exclude
    private List<SaleProduct> saleProductList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(id, stock.id) && Objects.equals(dateCreated, stock.dateCreated) &&
                Objects.equals(name, stock.name) && Objects.equals(quantity, stock.quantity) &&
                Objects.equals(unitValue, stock.unitValue) && Objects.equals(saleProductList, stock.saleProductList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateCreated, name, quantity, unitValue, saleProductList);
    }
}
