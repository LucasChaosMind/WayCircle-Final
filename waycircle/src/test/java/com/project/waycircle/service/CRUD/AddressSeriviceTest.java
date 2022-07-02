package com.project.waycircle.service.CRUD;

import com.project.waycircle.model.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class AddressSeriviceTest {

    @InjectMocks @Autowired
    private AddressServiceCRUD underTest;

    private  Address address;

    @BeforeEach
    public void setup(){
        address = Address.builder()
                .zipCode("0800")
                .city("Pato Branco")
                .street("Via do Conhecimento")
                .number("202 A")
                .build();
    }

    @Test
    void saveTest(){
        Address ad = underTest.save(address);
        Address add = underTest.readById(ad.getId());
        assertThat(ad.getZipCode()).isEqualTo(add.getZipCode());
    }
    @Test
    void updateTest(){
        Address ad = underTest.update(address);
        Address add = underTest.readById(ad.getId());
        assertThat(ad.getZipCode()).isEqualTo(add.getZipCode());
    }
    @Test
    void deleteTest(){
        Address ad = underTest.save(address);
        underTest.delete(address);
        Address add = underTest.readById(ad.getId());
        assertThat(ad.getZipCode()).isEqualTo(add.getZipCode());
    }
    @Test
    void readAllTest(){
        Address ad = underTest.save(address);
        List<Address> add = underTest.readAll();
        for(Address ux : add){
            if(ux.equals(ad)){
                assertThat(ad.getZipCode()).isEqualTo(ux.getZipCode());
            }
        }
    }

}
