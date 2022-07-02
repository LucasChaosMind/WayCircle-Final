package com.project.waycircle.service.CRUD;


import com.project.waycircle.model.Clothes;
import com.project.waycircle.repository.ClothesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j @Service
public record ClothesServiceCRUD(ClothesRepository cl) {

    public Clothes save(Clothes clothes){
        log.info("Salve clothes {}",clothes.getName());
        return cl.saveAndFlush(clothes);
    }
    public Clothes update(Clothes clothes){
        log.info("Update in clothes {}",clothes.getName());
        return cl.saveAndFlush(clothes);
    }
    public void delete(Clothes clothes){
        log.info("Delete clothes {}",clothes.getName());
        cl.delete(clothes);
    }
    public List<Clothes> readAll (){
        log.info("Read All clothes");
        return cl.findAll();
    }
    public Clothes readById (Long id){
        log.info("Read clothes id: {}",id);
        Clothes aux = cl.findById(id).orElse(null);
        if(aux == null){
            log.info("ID Clothes not found");
        }
        return aux;
    }
    public void deleteById(Long id){
        log.info("Delete clothes id: {}",id);
        cl.deleteById(id);
        log.info("Deleted");
    }


}
