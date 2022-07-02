package com.project.waycircle.service.useCases;

import com.project.waycircle.model.Clothes;
import com.project.waycircle.model.Orders;
import com.project.waycircle.service.CRUD.OrdersServiceCRUD;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service @Slf4j
public record OrderService(OrdersServiceCRUD ordersServiceCRUD) {

    public Orders newBuyOrder(Orders order){
        Double td = valueOrder(order);

        switch(order.getPayType()){
            case DEBIT : td *= 0.95;
                break;
            case BANKSLLP: td *= 0.85;
                break;
            case CREDIT1X: td *= 1.0;
                break;
            case CREDIT2X: td *= 1.01;
                break;
            case CREDIT3X: td *= 1.03;
                break;
            case CREDIT4X: td *= 1.05;
        }
        order.setValorTotal(td);
        return order;
    }
    private Double valueOrder(Orders order){
        return order.getClothes().stream().mapToDouble(Clothes::getValue).sum();
    }

    public void buy(Orders order,Boolean isPay){
        order = newBuyOrder(order);
        if(isPay){
            order.setPay(isPay);
            ordersServiceCRUD.update(order);
            log.info("Pagamento Feito - Ordem confirmada!");
        }
    }
}
