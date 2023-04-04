package com.unisabana.software.tienda.repository;

import com.unisabana.software.tienda.model.Sale;
import com.unisabana.software.tienda.model.SaleProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface SaleProductRepository extends JpaRepository<SaleProduct, Integer> {
    @Query(value = "SELECT * FROM SALE_PRODUCT AS sp WHERE sp.SALE_ID = :documentClient", nativeQuery = true)
    List<SaleProduct> searchByDocumentClient(@Param("documentClient") int documentClient);

    @Query(value = "SELECT * FROM SALE_PRODUCT AS sp, SALE AS s WHERE sp.SALE_ID = :saleID AND s.DATE_CREATED = :today",
            nativeQuery = true)
    List<Sale> limitTransactions(@Param("saleID") int documentClient, @Param("today") Date today);
}