package com.unisabana.software.tienda.controller;

import com.unisabana.software.tienda.controller.SaleController;
import com.unisabana.software.tienda.controller.SaleProductController;
import com.unisabana.software.tienda.controller.dto.SaleDTO;
import com.unisabana.software.tienda.model.Sale;
import com.unisabana.software.tienda.model.SaleProduct;
import com.unisabana.software.tienda.model.Stock;
import com.unisabana.software.tienda.service.SaleProductService;
import com.unisabana.software.tienda.service.SaleService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.unisabana.software.tienda.controller.dto.SaleDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaleControllerTest {
    @Mock
    private Stock stock;
    @Mock
    private Sale sale;

    private List<Sale> saleList() {
        List<Sale> saleProductList = new ArrayList<>();
        Sale sale = new Sale();
        sale.setId(1);
        //sale.setDateCreated(new Date(23-23-22);
        sale.setDocumentClient(123);
        sale.setTotalAmount(2);
        return saleList();
    }
    @Mock
    SaleService saleService;
    @InjectMocks
    SaleController saleController;

    @Test //que grabe y devuelva un true
    public void Given_A_Product_When_Invoke_saveSaleProduct_Then_Return_Boolean_True() {
        Mockito.when(saleService.save(sale)).thenReturn(true);
        //boolean result = saleController.saveSale();
        //assertTrue(true,result);
        //Mockito.verify(saleProductService).save(saleProduct);
    }
    @Test // que grabe y devuelva true
    public void Given_ProductStock_When_Invoke_saveStock_Then_Return_Boolean_True(){
    }
    @Test
    public void Given_A_Read_Of_A_sale_When_Invoke_read_Then_Return_Boolean_True(){
    }
    @Test
    public void Given_An_id_To_Delete_A_sale_When_Invoke_delete_Then_Return_Boolean_True(){
    }
    @Test
    public void Given_A_documenClient_And_Date_To_Verify_The_Limit_Of_A_Sale_When_Invoke_limitTransaction_Then_Return_Boolean_True(){
    }
    @Test // que grabe y devuelva true
    public void Given_An_ID_to_Search_A_Sale_When_Invoke_findById_Then_Return_Boolean_True(){
    }
    @Test // que grabe y devuelva true
    public void Given_A_documentClient_to_Search_A_Sale_When_Invoke_findByDocumentClient_Then_Return_Boolean_True(){
    }
    @Test // que grabe y devuelva true
    public void Given_A_Search_Of_All_Sales_When_Invoke_findAll_Then_Return_Boolean_True(){
    }

}