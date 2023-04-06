package com.unisabana.software.tienda.controller;

import com.unisabana.software.tienda.controller.dto.ResponseDTO;
import com.unisabana.software.tienda.controller.dto.SaleProductDTO;
import com.unisabana.software.tienda.model.Sale;
import com.unisabana.software.tienda.model.SaleProduct;
import com.unisabana.software.tienda.model.Stock;
import com.unisabana.software.tienda.service.SaleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.unisabana.software.tienda.controller.dto.SaleDTO;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class SaleControllerTest {
    @Mock
    private Stock stock;
    @Mock
    private List<SaleProductDTO> saleProducts;

    private List<Sale> saleList() {
        List<Sale> saleProductList = new ArrayList<>();
        Sale sale = new Sale();
        sale.setDateCreated(new Date(2023 - 04 - 07));
        sale.setDocumentClient((int) (Math.random() * 10000));
        sale.setTotalAmount(2);
        return saleList();
    }

    @Mock
    private SaleService saleService;

    @InjectMocks
    private SaleController saleController;

    @Test
    public void Given_Need_Save_Sale_When_Invoke_saveSale_Then_Return_Response_Positive() {
        SaleDTO saleDTO = new SaleDTO(555, new Date(2023-04-07), (int)(Math.random()*10000), 100, saleProducts);
        Mockito.when(saleService.save(new Sale())).thenReturn(true);
        ResponseDTO result = saleController.saveSale(saleDTO);
        Assertions.assertEquals("Se ha guardado exitosamente.", result.getResponse());
        Mockito.verify(saleService).save(new Sale());
    }

    @Test // que grabe y devuelva true
    public void Given_ProductStock_When_Invoke_saveStock_Then_Return_Boolean_True(){
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