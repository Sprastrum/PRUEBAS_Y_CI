package com.unisabana.software.tienda.model;

import com.unisabana.software.tienda.controller.dto.SaleDTO;
import com.unisabana.software.tienda.controller.dto.SaleProductDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "SALE")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 10) @Getter
    @Setter
    private Integer id;

    @Column(name = "DATE_CREATED") @Getter @Setter
    private Date dateCreated;

    @Column(name = "DOCUMENT_CLIENT", length = 10) @Getter @Setter
    private Integer documentClient;

    @Column(name = "TOTAL_AMOUNT", length = 10) @Getter @Setter
    private Integer totalAmount;

    @OneToMany
    @ToString.Exclude
    private List<SaleProductDTO> saleProductDTOList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Sale sale = (Sale) o;
        return id != null && Objects.equals(id, sale.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
