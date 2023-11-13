package com.esprit.examen.services;

import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;
import com.esprit.examen.services.StockServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StockServiceImplTest {

    @InjectMocks
    private StockServiceImpl stockService;

    @Mock
    private StockRepository stockRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllStocks() {
        List<Stock> expectedStocks = new ArrayList<>();
        expectedStocks.add(new Stock(1L, "Stock1", 100, 10));
        expectedStocks.add(new Stock(2L, "Stock2", 200, 20));

        when(stockRepository.findAll()).thenReturn(expectedStocks);
        List<Stock> result = stockService.retrieveAllStocks();
        assertEquals(expectedStocks, result);
    }

    @Test
    @Transactional
    public void testAddStock() {
        Stock stockToSave = new Stock(1L, "Stock1", 100, 10);
        when(stockRepository.save(stockToSave)).thenReturn(stockToSave);
        Stock result = stockService.addStock(stockToSave);
        assertEquals(stockToSave, result);
    }

    @Test
    public void testDeleteStock() {
        Long stockIdToDelete = 1L;
        stockService.deleteStock(stockIdToDelete);
        verify(stockRepository).deleteById(stockIdToDelete);
    }

    @Test
    public void testUpdateStock() {
        Stock stockToUpdate = new Stock(1L, "UpdatedStock", 150, 15);
        when(stockRepository.save(stockToUpdate)).thenReturn(stockToUpdate);
        Stock result = stockService.updateStock(stockToUpdate);
        assertEquals(stockToUpdate, result);
    }

    @Test
    public void testRetrieveStock() {
        Long stockIdToRetrieve = 1L;
        Stock expectedStock = new Stock(stockIdToRetrieve, "RetrievedStock", 100, 10);
        when(stockRepository.findById(stockIdToRetrieve)).thenReturn(java.util.Optional.ofNullable(expectedStock));
        Stock result = stockService.retrieveStock(stockIdToRetrieve);
        assertEquals(expectedStock, result);
    }
}
