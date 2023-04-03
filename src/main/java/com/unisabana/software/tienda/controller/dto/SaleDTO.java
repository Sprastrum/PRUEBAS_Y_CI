package com.unisabana.software.tienda.controller.dto;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "SALE")
public class SaleDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 10) @Getter @Setter
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
        SaleDTO saleDTO = (SaleDTO) o;
        return id != null && Objects.equals(id, saleDTO.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
