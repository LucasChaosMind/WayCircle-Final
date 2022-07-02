package com.project.waycircle.service.useCases;

import com.project.waycircle.model.Clothes;
import com.project.waycircle.model.Stock;
import com.project.waycircle.service.CRUD.ClothesServiceCRUD;
import com.project.waycircle.service.CRUD.StockServiceCRUD;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service @Slf4j
public record ClothesStockService (ClothesServiceCRUD clothesServiceCRUD,StockServiceCRUD stockServiceCRUD ){

    public Clothes newClothesAndNewStock(Clothes clothes, Integer qtd){
        log.info("Save New Clothes and New Stock");
        Stock stk = Stock.builder()
                        .quantity(qtd)
                        .lastModified(LocalDateTime.now())
                        .build();

        Stock st = stockServiceCRUD.save(stk);
        clothes.setStock(st);
        log.info("Saved Clothes: {} Stock Qtd: {}",clothes.getName(),stk.getQuantity());
        return  clothesServiceCRUD.save(clothes);

    }
    public boolean hasInStock(Stock stock,Integer qtd){
        return stock.getQuantity() >= qtd;
    }
    public void deleteClotheAndUpdateStock(Clothes clothes) {

        log.info("Stock Deleted");
        stockServiceCRUD.delete(clothes.getStock());

        log.info("Delete Clothes: {}", clothes.getName());
        clothesServiceCRUD.delete(clothes);

        log.info("Delete Success");

    }
    public Stock stockQuantityModification(Stock stock, Integer qtd){
        log.info("Atualizando quantidade  de {}",stock.getId());
        stock.setQuantity(stock.getQuantity() + qtd);
        stock.setLastModified(LocalDateTime.now());

        return stockServiceCRUD.update(stock);
    }

}
