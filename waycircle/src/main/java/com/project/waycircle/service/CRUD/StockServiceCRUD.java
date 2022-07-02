package com.project.waycircle.service.CRUD;

import com.project.waycircle.model.Stock;
import com.project.waycircle.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;

@Slf4j @Service
public record StockServiceCRUD(StockRepository stk){

    public Stock save(Stock stock){
        log.info("Salve Stock: {}",stock.getId());
        return stk.saveAndFlush(stock);
    }
    public Stock update(Stock stock){
        log.info("Salve Stock: {}",stock.getId() );
        return stk.saveAndFlush(stock);
    }
    public void delete(Stock stock){
        log.info("Salve Stock: {}",stock.getId());
        stk.delete(stock);
    }
    public List<Stock> readAll (){
        log.info("Read All Stock");
        return stk.findAll();
    }
    public Stock readById (Long id){
        log.info("Read Stock id: {}",id);
        Stock aux = stk.findById(id).get();
        if(aux == null){
            log.info("ID rating not found");
        }
        return aux;
    }
    public void deleteById(Long id){
        log.info("Delete Stock id: {}",id);
        stk.deleteById(id);
        log.info("Deleted");
    }

}
