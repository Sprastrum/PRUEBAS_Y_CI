package com.unisabana.software.tienda.repository;

import com.unisabana.software.tienda.model.Stock;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface StockRepository extends JpaRepository<Stock, Integer> {
    @Query(value = "SELECT * FROM STOCK AS s WHERE s.ID = :id", nativeQuery = true)
    Stock searchByID(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE STOCK AS s SET s.QUANTITY = :quantity WHERE s.ID = :id", nativeQuery = true)
    int setQuantity(@Param("quantity") int quantity, @Param("id") int id);
}
