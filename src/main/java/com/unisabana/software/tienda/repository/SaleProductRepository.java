package com.unisabana.software.tienda.repository;

import com.unisabana.software.tienda.model.SaleProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface SaleProductRepository extends JpaRepository<SaleProduct, Integer> {
    @Query(value = "SELECT p.* FROM SALE s, SALE_PRODUCT p WHERE p.SALE_ID = :saleID AND s.DATE_CREATED = :today",
            nativeQuery = true)
    List<SaleProduct> limitTransactions(@Param("saleID") int documentClient, @Param("today") Date today);

    @Query(value = "SELECT p.* FROM SALE s, SALE_PRODUCT p WHERE s.ID = p.SALE_ID AND s.DOCUMENT_CLIENT = " +
            ":documentClient", nativeQuery = true)
    List<SaleProduct> searchTransactionsByDocumentClient(@Param("documentClient") int documentClient);
}