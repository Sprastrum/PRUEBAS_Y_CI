package com.unisabana.software.tienda.controller;

import com.unisabana.software.tienda.AbstractTest;
import com.unisabana.software.tienda.controller.dto.ResponseDTO;
import com.unisabana.software.tienda.controller.dto.SaleDTO;
import com.unisabana.software.tienda.model.Sale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SaleIntegrationTest extends AbstractTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private List<SaleDTO> saleDTOS = new ArrayList<>();
    private SaleDTO saleDTO = new SaleDTO();
    private SaleDTO saleDTO2 = new SaleDTO();
    private SaleDTO saleDTO3 = new SaleDTO();
    private SaleDTO saleDTO4 = new SaleDTO();

    private static final String PATH_SALE_SAVE = "/sale/saveSale";
    private static final String PATH_LIST_SALES_SAVE = "/sale/saveSaleListProducts";
    private static final String PATH_DELETE_SALE = "sale/delete/{ID}";
    private static final String PATH_SEARCH_SALES_BY_DOCUMENT_CLIENT = "/sale/searchByDocumentClient/{DOCUMENTCLIENT}";
    private static final String PATH_ALL_SALES = "/sale/allSales";

    private void setUp() {
        saleDTO.setDateCreated(new Date(2023-04-07));
        saleDTO.setDocumentClient((int)(Math.random()*10000));
        saleDTO.setTotalAmount(1000);
        saleDTOS.add(saleDTO);

        saleDTO2.setDateCreated(new Date(2023-04-07));
        saleDTO2.setDocumentClient((int)(Math.random()*10000));
        saleDTO2.setTotalAmount(1000);
        saleDTOS.add(saleDTO2);

        saleDTO3.setDateCreated(new Date(2023-04-07));
        saleDTO3.setDocumentClient((int)(Math.random()*10000));
        saleDTO3.setTotalAmount(1000);
        saleDTOS.add(saleDTO3);

        saleDTO4.setDateCreated(new Date(2023-04-07));
        saleDTO4.setDocumentClient((int)(Math.random()*10000));
        saleDTO4.setTotalAmount(1000);
        saleDTOS.add(saleDTO3);
    }

    @Test
    void Given_Need_Save_Sale_When_Invoke_saveSale_Then_Return_Positive_Response() {
        setUp();

        Assertions.assertEquals("Se ha guardado exitosamente.",
                testRestTemplate.postForEntity(PATH_SALE_SAVE, saleDTO, ResponseDTO.class).getBody().getResponse());
    }

    @Test
    void Given_Need_Save_Sale_With_Same_Document_Client_When_Invoke_saveSale_Then_Return_Negative_Response() {
        setUp();

        Assertions.assertEquals("Se ha guardado exitosamente.",
                testRestTemplate.postForEntity(PATH_SALE_SAVE, saleDTO, ResponseDTO.class).getBody().getResponse());
        Assertions.assertEquals("Se ha guardado exitosamente.",
                testRestTemplate.postForEntity(PATH_SALE_SAVE, saleDTO, ResponseDTO.class).getBody().getResponse());
        Assertions.assertEquals("Se ha guardado exitosamente.",
                testRestTemplate.postForEntity(PATH_SALE_SAVE, saleDTO, ResponseDTO.class).getBody().getResponse());
        Assertions.assertEquals("No se ha guardado.",
                testRestTemplate.postForEntity(PATH_SALE_SAVE, saleDTO, ResponseDTO.class).getBody().getResponse());
    }

    @Test
    void Given_Need_Save_List_Sale_When_Invoke_saveSaleListProducts_Then_Return_Positive_Response() {
        setUp();
        List<String> strings = new ArrayList<>();

        for(SaleDTO s: saleDTOS) {
            strings.add(testRestTemplate.postForEntity(PATH_LIST_SALES_SAVE, saleDTOS, ResponseDTO.class).getBody().getResponse());
        }

        for(String s: strings) {
            Assertions.assertEquals("Se ha guardado exitosamente.", s);
        }
    }

    @Test
    void Given_Need_All_Sales_When_Invoke_allSales_Then_Return_All_Sales_List() {
        setUp();

        testRestTemplate.postForEntity(PATH_SALE_SAVE, saleDTO2, ResponseDTO.class);
        Assertions.assertNotNull(testRestTemplate.postForEntity(PATH_ALL_SALES, null, Sale.class).getBody());
    }

    @Test
    void Given_Need_Sales_All_With_Same_Document_Client_When_Invoke_saleSearchByDocumentClient_Then_Return_All_Sales_List_Same_Document_Client() {
        setUp();

        testRestTemplate.postForEntity(PATH_SALE_SAVE, saleDTO3, ResponseDTO.class);
        Assertions.assertNotNull(testRestTemplate.postForEntity(PATH_ALL_SALES, saleDTO3.getDocumentClient(), Sale.class).getBody());
    }

    @Test
    void Given_Need_Sales_All_With_Same_ID_When_Invoke_saleSearchByID_Then_Return_Sale_With_Same_ID() {
        setUp();

        testRestTemplate.postForEntity(PATH_SALE_SAVE, saleDTO4, ResponseDTO.class);
        Assertions.assertNotNull(testRestTemplate.postForEntity(PATH_ALL_SALES, saleDTO4.getId(), Sale.class).getBody());
    }
}
