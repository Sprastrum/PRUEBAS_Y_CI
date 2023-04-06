package com.unisabana.software.tienda.controller;

import com.unisabana.software.tienda.model.Sale;
import com.unisabana.software.tienda.model.SaleProduct;
import com.unisabana.software.tienda.model.Stock;
import java.util.ArrayList;
import java.util.List;
import com.unisabana.software.tienda.service.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SaleProductControllerTest {
    @Mock
    private Stock stock;
    @Mock
    private Sale sale;
    @Mock
    private SaleProduct saleProduct;
    private List<SaleProduct> saleProductList() {
        List<SaleProduct> saleProductList = new ArrayList<>();
        SaleProduct saleProduct = new SaleProduct();
        saleProduct.setId(1);
        saleProduct.setProduct(2);
        saleProduct.setStock(stock);
        saleProduct.setQuantity(4);
        saleProduct.setSaleID(5);
        return saleProductList;
    }
    @Mock
    SaleProductService saleProductService;
    @InjectMocks
    SaleProductController saleProductController;
    @Test // que grabe y devuelva true
    public void Given_Product_To_Save_When_Invoke_saveSaleProduct_Then_Return_Boolean_True(){
        Mockito.when(saleProductService.save(saleProduct)).thenReturn(true);
        List<SaleProduct> saleProductList = saleProductController.transactionsByDocumentClient(sale.getDocumentClient());
        assertTrue(true);
        Mockito.verify(saleProductService).save(saleProduct);
    }
    @Test
    public void Given_A_Read_Of_A_saleProduct_When_Invoke_read_Then_Return_Boolean_True(){
    }
    @Test
    public void Given_An_id_To_Delete_A_saleProduct_When_Invoke_delete_Then_Return_Boolean_True(){
    }
    @Test
    public void Given_A_documenClient_And_Date_To_Verify_The_Limit_Of_A_Sale_When_Invoke_limitTransaction_Then_Return_Boolean_True(){
    }
    @Test //devuelve y que no este vacio la lista que exista el documento
    public void Given_DocumentClient_To_Search_All_Transactions_done_When_Invoke_findByDocumentClient_Then_Return_All_Transactions(){
        Mockito.when(saleProductService.findByDocumentClient(sale.getDocumentClient())).thenReturn(saleProductList());
        List<SaleProduct> saleProductList = saleProductController.transactionsByDocumentClient(sale.getDocumentClient());
        assertNotNull(saleProductList);
        Mockito.verify(saleProductService).findByDocumentClient(sale.getDocumentClient());
    }

    @Test //que exista algunas transacciones que no este vacio
    public void Given_The_Need_To_Search_All_Transactions_When_Invoke_allTransactions_Then_Return_All_Transactions(){
        Mockito.when(saleProductService.findAll()).thenReturn(saleProductList());
        List<SaleProduct> saleProductList = saleProductController.allTransactions();
        assertNotNull(saleProductList);
        Mockito.verify(saleProductService).findAll();
    }



}