package com.unisabana.software.tienda.service;

import com.unisabana.software.tienda.model.Sale;
import com.unisabana.software.tienda.repository.SaleRepository;
import com.unisabana.software.tienda.service.impl.SaleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SaleServiceTest {
    @InjectMocks
    private SaleServiceImpl saleService;
    @Mock
    private SaleRepository saleRepository;
    private Sale sale1;

    @Test //que grabe y devuelva un true
    public void Given_A_Product_When_Invoke_saveSaleProduct_Then_Return_Boolean_True() {
        int id = 2;
        Date today = new Date();
        Sale sale1 = new Sale(id, today, 2, 30, null);
        Mockito.when(saleRepository.existsById(id)).thenReturn(true);
        boolean result = saleService.save(sale1);
        assertTrue(result);
        Mockito.verify(saleRepository).save(sale1);
        Mockito.verify(saleRepository).existsById(id);
    }

    @Test // que grabe y devuelva true
    public void Given_An_Id_To_Read_A_Sale_When_Invoke_read_Then_Return_Product() {
        int id = 2;
        Date today = new Date();
        Sale sale1 = new Sale(id, today, 2, 30, null);
        Mockito.when(saleRepository.getReferenceById(id)).thenReturn(sale1);
        Sale result = saleService.read(id);
        assertEquals(sale1, result);
        Mockito.verify(saleRepository).getReferenceById(id);
    }

    @Test
    public void Given_An_id_To_Delete_A_sale_When_Invoke_delete_Then_Return_Boolean_True() {
        int id = 2;
        Mockito.when(saleRepository.existsById(id)).thenReturn(false);
        boolean result = saleService.delete(id);
        assertTrue(result);
        Mockito.verify(saleRepository).deleteById(id);
        Mockito.verify(saleRepository).existsById(id);
    }

    @Test
    public void Given_A_documentClient_And_A_Date_To_Verify_The_Limit_Of_Transactions_Of_2Sales_When_Invoke_limitTransaction_Then_Return_Boolean_True() {
        int documentClient = 123;
        java.sql.Date today = new java.sql.Date(2023, 2, 22);
        List<Sale> saleList = new ArrayList<>();
        Sale sale1 = new Sale(2, today, 2, 30, null);
        Sale sale2 = new Sale(1, today, 2, 50, null);
        saleList.add(sale1);
        saleList.add(sale2);
        Mockito.when(saleRepository.limitTransactions(documentClient, today)).thenReturn(saleList);
        boolean result = saleService.limitTransaction(documentClient, today);
        assertTrue(result);
        Mockito.verify(saleRepository).limitTransactions(documentClient, today);
    }

    @Test
    public void Given_A_documentClient_And_A_Date_To_Verify_The_Limit_Of_Transactions_Of_4Sales_When_Invoke_limitTransaction_Then_Return_Boolean_False() {
        int documentClient = 123;
        java.sql.Date today = new java.sql.Date(2023, 2, 22);
        List<Sale> saleList = new ArrayList<>();
        Sale sale1 = new Sale(2, today, 2, 30, null);
        Sale sale2 = new Sale(1, today, 3, 50, null);
        Sale sale3 = new Sale(3, today, 4, 30, null);

        saleList.add(sale1);
        saleList.add(sale2);
        saleList.add(sale3);
        Mockito.when(saleRepository.limitTransactions(documentClient, today)).thenReturn(saleList);
        boolean result = saleService.limitTransaction(documentClient, today);
        assertFalse(result);
        Mockito.verify(saleRepository).limitTransactions(documentClient, today);
    }

    @Test // que grabe y devuelva true
    public void Given_An_ID_to_Search_A_Sale_When_Invoke_findById_Then_Return_Sale() {
        Date today = new Date();
        int id = 2;
        Sale sale1 = new Sale(id, today, 2, 30, null);
        Sale expectedsale = new Sale(id, today, 2, 30, null);
        Mockito.when(saleRepository.searchByID(id)).thenReturn(sale1);
        Sale result = saleService.findByID(id);
        assertEquals(expectedsale, result);
        Mockito.verify(saleRepository).searchByID(id);
    }

    @Test // que grabe y devuelva true
    public void Given_A_documentClient_to_Search_A_Sale_When_Invoke_findByDocumentClient_Then_Return_Boolean_True() {
        int documentClient = 123;
        java.sql.Date today = new java.sql.Date(2023, 2, 22);
        List<Sale> saleList = new ArrayList<>();
        Sale sale1 = new Sale(2, today, 123, 30, null);
        Sale sale2 = new Sale(1, today, 123, 50, null);
        Sale sale3 = new Sale(3, today, 123, 30, null);
        saleList.add(sale1);
        saleList.add(sale2);
        saleList.add(sale3);
        Mockito.when(saleRepository.searchByDocumentClient(documentClient)).thenReturn(saleList);
        List<Sale> result = saleService.findByDocumentClient(documentClient);
        assertTrue(saleList.containsAll(result));
        Mockito.verify(saleRepository).searchByDocumentClient(documentClient);
    }

    @Test // que grabe y devuelva true
    public void Given_A_Search_Of_All_Sales_When_Invoke_findAll_Then_Return_Boolean_True() {
        List<Sale> saleList = new ArrayList<>();
        Date today = new Date();
        Sale sale1 = new Sale(2, today, 123, 30, null);
        Sale sale2 = new Sale(1, today, 123, 50, null);
        Sale sale3 = new Sale(3, today, 13, 30, null);
        saleList.add(sale1);
        saleList.add(sale2);
        saleList.add(sale3);
        Mockito.when(saleRepository.findAll()).thenReturn(saleList);
        List<Sale> result = saleService.findAll();
        assertTrue(saleList.containsAll(result));
        Mockito.verify(saleRepository).findAll();
    }
}
