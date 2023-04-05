package com.unisabana.software.tienda.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

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
    @Column(name = "ID", nullable = false, length = 10)
    @Getter
    @Setter
    private Integer id;

    @Column(name = "DATE_CREATED", nullable = false)
    @Getter
    @Setter
    private Date dateCreated;

    @Column(name = "NAME", nullable = false, length = 100)
    @Getter
    @Setter
    private String name;

    @Column(name = "QUANTITY", nullable = false, length = 10)
    @Getter
    @Setter
    private Integer quantity;

    @Column(name = "UNIT_VALUE", nullable = false, length = 10)
    @Getter
    @Setter
    private Integer unitValue;

    @OneToMany
    @ToString.Exclude
    private List<SaleProduct> saleProductDTOList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Stock stock = (Stock) o;
        return id != null && Objects.equals(id, stock.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
