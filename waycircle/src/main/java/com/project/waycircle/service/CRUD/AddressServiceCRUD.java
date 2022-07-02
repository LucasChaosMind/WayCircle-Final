package com.project.waycircle.service.CRUD;

import com.project.waycircle.model.Address;
import com.project.waycircle.model.Clothes;
import com.project.waycircle.model.Customer;
import com.project.waycircle.repository.AddressRepository;
import com.project.waycircle.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j @Service
public record AddressServiceCRUD(AddressRepository ad) {

    public Address save(Address address){
        log.info("Salve Address {}",address.getZipCode());
        return ad.saveAndFlush(address);
    }
    public Address update(Address address){
        log.info("Update in Address {}",address.getCity());
        return ad.saveAndFlush(address);
    }
    public void delete(Address address){
        log.info("Delete address {}",address.getCity());
        ad.delete(address);
    }
    public List<Address> readAll (){
        log.info("Read All address");
        return ad.findAll();
    }
    public Address readById (Long id){
        log.info("Read address id: {}",id);
        Address aux = ad.findById(id).orElse(null);
        if(aux == null){
            log.info("ID Address not found");
        }
        return aux;
    }
    public void deleteById(Long id){
        log.info("Delete address id: {}",id);
        ad.deleteById(id);
        log.info("Deleted");
    }
}
