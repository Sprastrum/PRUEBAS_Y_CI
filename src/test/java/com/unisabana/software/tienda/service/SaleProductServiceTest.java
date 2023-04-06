package com.example.demo.service;

import com.unisabana.software.tienda.model.SaleProduct;
import com.unisabana.software.tienda.repository.SaleProductRepository;
import com.unisabana.software.tienda.service.impl.SaleProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class SaleProductServiceTest {

    @Mock
    private SaleProductRepository saleProductRepository;
    @InjectMocks
    private SaleProductServiceImpl saleProductService;

    @Test //que grabe y devuelva un true
    public void Given_A_saleProduct_When_Invoke_save_Then_Return_Boolean_True() {
        int id = 2;
        SaleProduct saleProduct1 = new SaleProduct(id, 2, null, 2, 30, null);
        Mockito.when(saleProductRepository.existsById(id)).thenReturn(true);
        boolean result = saleProductService.save(saleProduct1);
        assertTrue(result);
        Mockito.verify(saleProductRepository).save(saleProduct1);
        Mockito.verify(saleProductRepository).existsById(id);
    }

    @Test // que grabe y devuelva true
    public void Given_An_Id_To_Read_A_SaleProduct_When_Invoke_read_Then_Return_SaleProduct() {
        int id = 2;
        Date today = new Date();
        SaleProduct saleProduct1 = new SaleProduct(id, 2, null, 2, 30, null);
        Mockito.when(saleProductRepository.getReferenceById(id)).thenReturn(saleProduct1);
        SaleProduct result = saleProductService.read(id);
        assertEquals(saleProduct1, result);
        Mockito.verify(saleProductRepository).getReferenceById(id);
    }

    @Test
    public void Given_An_id_To_Delete_A_sale_When_Invoke_delete_Then_Return_Boolean_True() {
        int id = 2;
        Mockito.when(saleProductRepository.existsById(id)).thenReturn(false);
        boolean result = saleProductService.delete(id);
        assertTrue(result);
        Mockito.verify(saleProductRepository).deleteById(id);
        Mockito.verify(saleProductRepository).existsById(id);
    }

    @Test
    public void Given_A_documentClient_And_A_Date_To_Verify_The_Limit_Of_Transactions_Of_2Sales_When_Invoke_limitTransaction_Then_Return_Boolean_True() {
        int documentClient = 123;
        java.sql.Date today = new java.sql.Date(2023, 2, 22);
        List<SaleProduct> saleProductList = new ArrayList<>();
        SaleProduct saleProduct1 = new SaleProduct(1, 2, null, 2, 30, null);
        SaleProduct saleProduct2 = new SaleProduct(1, 2, null, 2, 50, null);
        saleProductList.add(saleProduct1);
        saleProductList.add(saleProduct2);
        Mockito.when(saleProductRepository.limitTransactions(documentClient, today)).thenReturn(saleProductList);
        boolean result = saleProductService.limitTransaction(documentClient, today);
        assertTrue(result);
        Mockito.verify(saleProductRepository).limitTransactions(documentClient, today);
    }

    @Test // que grabe y devuelva true
    public void Given_A_documentClient_to_Search_A_SaleProduct_When_Invoke_findByDocumentClient_Then_Return_Boolean_True() {
        int documentClient = 123;
        java.sql.Date today = new java.sql.Date(2023, 2, 22);
        List<SaleProduct> saleProductList = new ArrayList<>();
        SaleProduct saleProduct1 = new SaleProduct(1, 2, null, 2, 30, null);
        SaleProduct saleProduct2 = new SaleProduct(1, 2, null, 2, 50, null);
        SaleProduct saleProduct3 = new SaleProduct(3, 2, null, 123, 30, null);
        saleProductList.add(saleProduct1);
        saleProductList.add(saleProduct2);
        saleProductList.add(saleProduct3);
        Mockito.when(saleProductRepository.searchTransactionsByDocumentClient(documentClient)).thenReturn(saleProductList);
        List<SaleProduct> result = saleProductService.findByDocumentClient(documentClient);
        assertTrue(saleProductList.containsAll(result));
        Mockito.verify(saleProductRepository).searchTransactionsByDocumentClient(documentClient);
    }

    @Test // que grabe y devuelva true
    public void Given_A_Search_Of_All_Sales_When_Invoke_findAll_Then_Return_Boolean_True() {
        int documentClient = 123;
        java.sql.Date today = new java.sql.Date(2023, 2, 22);
        List<SaleProduct> saleProductList = new ArrayList<>();
        SaleProduct saleProduct1 = new SaleProduct(1, 2, null, 2, 30, null);
        SaleProduct saleProduct2 = new SaleProduct(1, 2, null, 2, 50, null);
        SaleProduct saleProduct3 = new SaleProduct(3, 2, null, 123, 30, null);
        saleProductList.add(saleProduct1);
        saleProductList.add(saleProduct2);
        saleProductList.add(saleProduct3);
        Mockito.when(saleProductRepository.findAll()).thenReturn(saleProductList);
        List<SaleProduct> result = saleProductService.findAll();
        assertTrue(saleProductList.containsAll(result));
        Mockito.verify(saleProductRepository).findAll();
    }

}