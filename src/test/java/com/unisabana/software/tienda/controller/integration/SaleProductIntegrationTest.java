package com.unisabana.software.tienda.controller.integration;

import com.unisabana.software.tienda.AbstractTest;
import com.unisabana.software.tienda.controller.SaleController;
import com.unisabana.software.tienda.controller.SaleProductController;
import com.unisabana.software.tienda.controller.StockController;
import com.unisabana.software.tienda.controller.dto.ResponseDTO;
import com.unisabana.software.tienda.controller.dto.SaleDTO;
import com.unisabana.software.tienda.controller.dto.SaleProductDTO;
import com.unisabana.software.tienda.controller.dto.StockDTO;
import com.unisabana.software.tienda.model.Sale;
import com.unisabana.software.tienda.model.SaleProduct;
import com.unisabana.software.tienda.service.SaleProductService;
import com.unisabana.software.tienda.service.SaleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@AutoConfigureMockMvc
public class SaleProductIntegrationTest extends AbstractTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private SaleService saleService;
    private SaleProductService saleProductService;
    @Autowired
    private SaleController saleController;
    @Autowired
    private StockController stockController;
    @Autowired
    private SaleProductController saleProductController;
    private HttpEntity<String> request = new HttpEntity<>(null);
    private SaleDTO saleDTO = new SaleDTO();
    private StockDTO stockDTO = new StockDTO();
    private SaleProductDTO saleProductDTO = new SaleProductDTO();
    private SaleProductDTO saleProductDTO1 = new SaleProductDTO();
    private SaleProductDTO saleProductDTO2 = new SaleProductDTO();

    private static final String PATH_SALE_PRODUCT_SAVE = "/saleProduct/saveSaleProduct";
    private static final String PATH_SEARCH_TRANSACTIONS_BY_DOCUMENT_CLIENT = "/saleProduct/salesProductsByDocumentClient/{DOCUMENT_CLIENT}";
    private static final String PATH_ALL_TRANSACTIONS = "/saleProduct/allSalesProducts";

    private String DOCUMENT_CLIENT;
    @BeforeEach
    void setUp() {
        saleDTO.setId(18);
        saleDTO.setDocumentClient(123);
        stockDTO.setId(1);
        stockDTO.setQuantity(100);

        saleProductDTO.setProduct(1);
        saleProductDTO.setQuantity(100);
        saleProductDTO.setSaleID(18);
        saleProductDTO.setSaleDTO(saleDTO);
        saleProductDTO.setStockDTO(stockDTO);

        saleProductDTO1.setProduct(1);
        saleProductDTO1.setQuantity(100);
        saleProductDTO1.setSaleID(18);
        saleProductDTO1.setSaleDTO(saleDTO);
        saleProductDTO1.setStockDTO(stockDTO);


        saleProductDTO2.setProduct(1);
        saleProductDTO2.setQuantity(100);
        saleProductDTO2.setSaleID(18);
        saleProductDTO2.setSaleDTO(saleDTO);
        saleProductDTO2.setStockDTO(stockDTO);

        saleProductController.saveSaleProduct(saleProductDTO1);
    }

    @Test
    void Given_Need_All_Transactions_When_Invoke_allTransactions_Then_Return_All_Transactions() {
        Assertions.assertNotNull(testRestTemplate.postForEntity(PATH_ALL_TRANSACTIONS, null, Sale.class).getBody());
    }

    @Test
    void Given_Need_Sales_All_With_Same_Document_Client_When_Invoke_saleSearchByDocumentClient_Then_Return_All_Sales_List_Same_Document_Client() {
        testRestTemplate.postForEntity(PATH_SALE_PRODUCT_SAVE, saleProductDTO1, ResponseDTO.class);
        ResponseEntity<List<SaleProduct>> response = testRestTemplate.exchange(PATH_SEARCH_TRANSACTIONS_BY_DOCUMENT_CLIENT,
                HttpMethod.GET, request, new ParameterizedTypeReference<List<SaleProduct>>() {}, DOCUMENT_CLIENT);

        List<SaleProduct> saleProducts = new ArrayList<>(response.getBody());

        Assertions.assertNotNull(response);
        Assertions.assertEquals(saleProductDTO1.getSaleDTO().getDocumentClient(), saleProducts.get(0).getSale()
                .getDocumentClient());
    }

    @Test
    void Given_Need_Save_Sale_Product_When_Invoke_saveSaleProduct_Then_Return_Positive_Response() {
        Assertions.assertEquals("Se ha guardado exitosamente.",
                testRestTemplate.postForEntity(PATH_SALE_PRODUCT_SAVE, saleProductDTO2, ResponseDTO.class).getBody().getResponse());
    }
}
