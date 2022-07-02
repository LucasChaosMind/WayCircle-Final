package com.project.waycircle.service.CRUD;

import com.project.waycircle.model.Orders;
import com.project.waycircle.repository.OrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j @Service
public record OrdersServiceCRUD(OrdersRepository ord) {

    public Orders save(Orders orders){
        log.info("Salve Order: {}",orders.getId());
        return ord.saveAndFlush(orders);
    }
    public Orders update(Orders orders){
        log.info("Update in order: {}",orders.getId());
        return ord.saveAndFlush(orders);
    }
    public void delete(Orders orders){
        log.info("Delete order: {}",orders.getId());
        ord.delete(orders);
    }
    public List<Orders> readAll (){
        log.info("Read All orders");
        return ord.findAll();
    }
    public Orders readById (Long id){
        log.info("Read order id: {}",id);
        Orders aux = ord.findById(id).get();
        if(aux == null){
            log.info("ID orders not found");
        }
        return aux;
    }
    public void deleteById(Long id){
        log.info("Delete order id: {}",id);
        ord.deleteById(id);
        log.info("Deleted");
    }
}
