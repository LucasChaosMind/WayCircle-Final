package com.project.waycircle.service.useCases;


import com.project.waycircle.model.Clothes;
import com.project.waycircle.model.Stock;
import com.project.waycircle.model.enums.Size;
import com.project.waycircle.repository.ClothesRepository;
import com.project.waycircle.repository.StockRepository;
import com.project.waycircle.service.CRUD.ClothesServiceCRUD;
import com.project.waycircle.service.CRUD.StockServiceCRUD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(MockitoExtension.class)
public class ClothesStockServiceTest {


    private ClothesStockService underTest;

    @Mock
    private ClothesServiceCRUD clothesServiceCRUD;
    @Mock
    private StockServiceCRUD stockServiceCRUD;
   /* @Mock
    private ClothesRepository clothesRepository;
    @Mock
    private StockRepository stockRepository;*/

    private Clothes clothes;


    @BeforeEach
    void setup() {
        underTest = new ClothesStockService(clothesServiceCRUD,stockServiceCRUD);
        /*clothesServiceCRUD = new ClothesServiceCRUD(clothesRepository);
        stockServiceCRUD = new StockServiceCRUD(stockRepository);*/

    }

    @Test
    void newClothesAndNewStockTest(){
        //given


        clothes = Clothes.builder()
                .name("UnderTest")
                .description("UnderTest")
                .size(Size.M)
                .value(10.50)
                .build();

        BDDMockito.given(stockServiceCRUD.save(Mockito.any())).willReturn(Stock.builder()
                .quantity(1)
                .lastModified(LocalDateTime.now())
                .build());
        BDDMockito.given(clothesServiceCRUD.save(Mockito.any())).willReturn(clothes);

        //when
        Clothes result = underTest.newClothesAndNewStock(clothes,1);

        //then
        assertThat(result.getStock().getQuantity()).isEqualTo(1);

    }
    @Test
    void hasInStockTest(){
        clothes = Clothes.builder()
                .name("UnderTest")
                .description("UnderTest")
                .size(Size.M)
                .value(10.50)
                .stock(Stock.builder()
                        .quantity(5)
                        .lastModified(LocalDateTime.now())
                        .build())
                .build();
        boolean result = underTest.hasInStock(clothes.getStock(),5);

        assertThat(result).isEqualTo(true);
    }
    @Test
    void deleteClotheAndUpdateStock() {
        clothes = Clothes.builder()
                .name("UnderTest")
                .description("UnderTest")
                .size(Size.M)
                .value(10.50)
                .stock(Stock.builder()
                        .quantity(5)
                        .lastModified(LocalDateTime.now())
                        .build())
                .build();
        clothesServiceCRUD.save(clothes);
        stockServiceCRUD.save(clothes.getStock());

        underTest.deleteClotheAndUpdateStock(clothes);

        var result = clothesServiceCRUD.readById(clothes.getId());

        assertThat(result).isEqualTo(null);

    }
    @Test
    void stockQuantityModificationTest(){
        Stock expected = Stock.builder().quantity(1).lastModified(LocalDateTime.now()).build();

        BDDMockito.given(stockServiceCRUD.update(Mockito.any())).willReturn(Stock.builder().quantity(6).lastModified(LocalDateTime.now()).build());

        Stock result = underTest.stockQuantityModification(expected,5);

        assertThat(result.getQuantity()).isEqualTo(6);
    }
}
