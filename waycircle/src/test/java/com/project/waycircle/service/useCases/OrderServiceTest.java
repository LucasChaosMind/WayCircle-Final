package com.project.waycircle.service.useCases;

import com.project.waycircle.model.Clothes;
import com.project.waycircle.model.Customer;
import com.project.waycircle.model.Orders;
import com.project.waycircle.model.enums.Pay;
import com.project.waycircle.service.CRUD.OrdersServiceCRUD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrdersServiceCRUD ordersServiceCRUD;


    private OrderService underTest;


    private Orders expected;

    @BeforeEach
    public void setup(){
        underTest = new OrderService(ordersServiceCRUD);

        List<Clothes> cl = new ArrayList<>();
        cl.add(Clothes.builder().name("UnderTest").value(150.2).build());
        cl.add(Clothes.builder().name("UnderTest").value(150.2).build());

        expected = Orders.builder()
                .customer(Customer.builder().name("UnderTest").cpf("0000").build())
                .clothes(cl)
                .payType(Pay.CREDIT1X)
                .build();

    }

    @Test
    void newBuyOrderTest(){
        Orders result = underTest.newBuyOrder(expected);
        assertThat(result.getValorTotal()).isEqualTo(300.4);
    }
    @Test
    void buyTest(){

        underTest.buy(expected,true);

        assertThat(expected.isPay()).isEqualTo(true);

    }
}
