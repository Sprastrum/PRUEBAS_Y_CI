package com.unisabana.software.tienda.service;
import com.unisabana.software.tienda.model.Stock;
import com.unisabana.software.tienda.repository.StockRepository;
import com.unisabana.software.tienda.service.impl.StockServiceImpl;
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
public class StockServiceTest {
    @InjectMocks
    private StockServiceImpl stockService;
    @Mock
    private StockRepository stockRepository;

    @Test
    public void Given_ProductStock_When_Invoke_saveStock_Then_Return_Boolean_True(){
        int id = 2;
        Date today = new Date();
        Stock product1 = new Stock(id, today, "jabon", 2, 30, null);
        Mockito.when(stockRepository.existsById(id)).thenReturn(true);
        boolean result = stockService.save(product1);
        assertTrue(result);
        Mockito.verify(stockRepository).save(product1);
        Mockito.verify(stockRepository).existsById(id);
    }
    @Test
    public void Given_A_Read_Of_A_Stock_When_Invoke_read_Then_Return_Product() {
        int id = 2;
        Date today = new Date();
        Stock product1 = new Stock(id, today, "jabon", 2, 30, null);
        Mockito.when(stockRepository.getReferenceById(id)).thenReturn(product1);
        Stock result = stockService.read(id);
        assertEquals(product1, result);
        Mockito.verify(stockRepository).getReferenceById(id);
    }
    @Test
    public void Given_An_id_To_Delete_A_Stock_When_Invoke_delete_Then_Return_Boolean_True(){
        int id = 2;
        Mockito.when(stockRepository.existsById(id)).thenReturn(false);
        boolean result = stockService.delete(id);
        assertTrue(result);
        Mockito.verify(stockRepository).existsById(id);
        Mockito.verify(stockRepository).deleteById(id);
    }
    @Test
    public void Given_An_id_To_Delete_A_Stock_When_Invoke_delete_Then_Return_Boolean_False(){
        int id = 3;
        Mockito.when(stockRepository.existsById(id)).thenReturn(false);
        stockService.delete(id);
        Mockito.verify(stockRepository).deleteById(id);
        Mockito.verify(stockRepository).existsById(id);
    }
    @Test
    public void Given_An_id_To_Search_A_Stock_When_Invoke_findById_Then_Return_Boolean_True(){
        Date today = new Date();
        int id = 2;
        Stock product1 = new Stock(id,today ,"jabon",2,30,null);
        Stock expectedProduct = new Stock(id,today ,"jabon",2,30,null);
        Mockito.when(stockRepository.searchByID(id)).thenReturn(product1);
        Stock result = stockService.findByID(id);
        assertEquals(expectedProduct,result);
        Mockito.verify(stockRepository).searchByID(id);
    }
    @Test
    public void Given_A_Search_Of_All_Stocks_When_Invoke_allStocks_Then_Return_All_Stocks() {
        List<Stock> stockList = new ArrayList<>();
        Date today = new Date();
        Stock product1 = new Stock(2,today ,"jabon",2,30,null);
        Stock product2 = new Stock(1,today ,"shampoo",2,50,null);
        stockList.add(product1);
        stockList.add(product2);
        Mockito.when(stockRepository.findAll()).thenReturn(stockList);
        List<Stock> result = stockService.findAll();
        assertTrue(stockList.containsAll(result));
        Mockito.verify(stockRepository).findAll();
    }
    @Test
    public void Given_A_Quantity_And_id_Of_A_Product_When_Invoke_setQuantity_Then_Success(){
        int quantity = 2;
        int id = 1;
        stockService.setQuantity(quantity,id);
        Mockito.verify(stockRepository).setQuantity(quantity,id);
    }
}