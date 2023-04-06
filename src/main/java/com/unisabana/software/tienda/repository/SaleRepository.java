package com.unisabana.software.tienda.repository;

import com.unisabana.software.tienda.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
@Component
public interface SaleRepository extends JpaRepository<Sale, Integer> {
    @Query(value = "SELECT * FROM SALE AS s WHERE s.DOCUMENT_CLIENT = :documentClient", nativeQuery = true)
    List<Sale> searchByDocumentClient(@Param("documentClient") int documentClient);

    @Query(value = "SELECT * FROM SALE AS s WHERE s.ID = :id", nativeQuery = true)
    Sale searchByID(@Param("id") int id);

    @Query(value = "SELECT * FROM SALE AS s WHERE s.DOCUMENT_CLIENT = :documentClient AND s.DATE_CREATED = :today",
            nativeQuery = true)
    List<Sale> limitTransactions(@Param("documentClient") int documentClient, @Param("today") Date today);
}
