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
@Table(name = "SALE")
public class Sale {
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

    @Column(name = "DOCUMENT_CLIENT", length = 10)
    @Getter
    @Setter
    private Integer documentClient;

    @Column(name = "TOTAL_AMOUNT", length = 10)
    @Getter
    @Setter
    private Integer totalAmount;

    @OneToMany
    @ToString.Exclude
    private List<SaleProduct> saleProductList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(id, sale.id) && Objects.equals(dateCreated, sale.dateCreated) && Objects.equals(documentClient, sale.documentClient) && Objects.equals(totalAmount, sale.totalAmount) && Objects.equals(saleProductList, sale.saleProductList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateCreated, documentClient, totalAmount, saleProductList);
    }
}