package com.project.waycircle.service.CRUD;

import com.project.waycircle.model.Customer;
import com.project.waycircle.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @Slf4j
public record CustomerServiceCRUD (CustomerRepository cst) {

    public Customer save(Customer customer){
        log.info("Salve Customer {}",customer.getName());
        return cst.saveAndFlush(customer);
    }
    public Customer update(Customer customer){
        log.info("Update in Customer {}",customer.getName());
        return cst.saveAndFlush(customer);
    }
    public void delete(Customer customer){
        log.info("Delete Customer {}",customer.getName());
        cst.delete(customer);
    }
    public List<Customer> readAll (){
        log.info("Read All Customer");
        return cst.findAll();
    }
    public Customer readById (Long id){
        log.info("Read Customer id: {}",id);
        Customer aux = cst.findById(id).get();
        if(aux == null){
            log.info("ID Customer not found");
        }
        return aux;
    }
    public void deleteById(Long id){
        log.info("Delete Customer id: {}",id);
        cst.deleteById(id);
        log.info("Deleted");
    }
}
