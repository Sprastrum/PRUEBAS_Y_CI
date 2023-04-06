package com.unisabana.software.tienda.controller.integration;

import com.unisabana.software.tienda.AbstractTest;
import com.unisabana.software.tienda.controller.dto.ResponseDTO;
import com.unisabana.software.tienda.controller.dto.StockDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class StockIntegrationTest extends AbstractTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private HttpEntity<String> request = new HttpEntity<>(null);
    private StockDTO stockDTO = new StockDTO();
    private StockDTO stockDTO1 = new StockDTO();
    private StockDTO stockDTO2 = new StockDTO();
    private StockDTO stockDTO3 = new StockDTO();

    private static final String PATH_STOCK_SAVE = "/stock/saveStock";
    private static final String PATH_LIST_SALES_SAVE = "/sale/saveSaleListProducts";
    private static final String PATH_SEARCH_SALES_BY_ID = "/sale/searchByID/{ID}";
    private static final String PATH_SEARCH_SALES_BY_DOCUMENT_CLIENT = "/sale/searchByDocumentClient/{DOCUMENT_CLIENT}";
    private static final String PATH_ALL_STOCKS = "/stock/allStocks";
@BeforeEach
void setUp() {
        stockDTO.setId(123);
        stockDTO.setDateCreated(new Date(2023- 5 - 7));
        stockDTO.setName("Hamburguesa");
        stockDTO.setQuantity(1000);
        stockDTO.setUnitValue(15000);
        stockDTO.setSaleProductDTOS(new ArrayList<>());

        stockDTO1.setDateCreated(new Date(2023-04-07));
        stockDTO1.setName("Pizza");
        stockDTO1.setQuantity(1000);
        stockDTO1.setUnitValue(10000);

        stockDTO2.setDateCreated(new Date(2023-04-07));
        stockDTO2.setName("Hot Dog");
        stockDTO2.setQuantity(1000);
        stockDTO2.setUnitValue(5000);
    }

    @Test
    void Given_Need_Save_Stock_When_Invoke_saveStock_Then_Return_Positive_Response() {
        Assertions.assertEquals("Se ha guardado exitosamente.",
                testRestTemplate.postForEntity(PATH_STOCK_SAVE, stockDTO, ResponseDTO.class).getBody().getResponse());
    }

    @Test
    void Given_Need_All_Sales_When_Invoke_allSales_Then_Return_All_Sales_List() {
        testRestTemplate.postForEntity(PATH_STOCK_SAVE, stockDTO1, ResponseDTO.class);
        Assertions.assertNotNull(testRestTemplate.getForEntity(PATH_ALL_STOCKS, List.class).getBody());
    }
}
