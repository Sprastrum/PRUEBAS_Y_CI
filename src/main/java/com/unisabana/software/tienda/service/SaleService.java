package com.unisabana.software.tienda.service;

import com.unisabana.software.tienda.model.Sale;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public interface SaleService {
    boolean save(Sale sale);

    Sale read(int id);

    boolean delete(int id);

    boolean limitTransaction(int documentClient);

    Sale findByID(int id);

    List<Sale> findByDocumentClient(int documentClient);

    List<Sale> findAll();

    List<Sale> findByDocumentClientAndDateCreated(int documentClient, Date valueOf);
}
