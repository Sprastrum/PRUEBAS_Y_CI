package com.unisabana.software.tienda.service;

import com.unisabana.software.tienda.model.Sale;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Component
@Service
public interface SaleService {
    boolean save(Sale sale);

    Sale read(int id);

    boolean delete(int id);

    boolean limitTransaction(int documentClient, Date date);

    Sale findByID(int id);

    List<Sale> findByDocumentClient(int documentClient);

    List<Sale> findAll();
}
