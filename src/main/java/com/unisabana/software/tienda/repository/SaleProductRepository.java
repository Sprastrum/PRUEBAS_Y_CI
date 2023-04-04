package com.unisabana.software.tienda.repository;

import com.unisabana.software.tienda.model.SaleProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleProductRepository extends JpaRepository<SaleProduct, Integer> {
    @Query(value = "SELECT * FROM SALE_PRODUCT AS sp,  WHERE sp.SALE_ID = :documentClient", nativeQuery = true)
    List<SaleProduct> searchByDocumentClient(@Param("documentClient") int documentClient);
}