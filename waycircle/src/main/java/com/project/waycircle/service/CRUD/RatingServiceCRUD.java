package com.project.waycircle.service.CRUD;

import com.project.waycircle.model.Rating;
import com.project.waycircle.repository.RatingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j @Service
public record RatingServiceCRUD(RatingRepository rat) {

    public Rating save(Rating rating){
        log.info("Salve rating: {}",rating.getId());
        return rat.saveAndFlush(rating);
    }
    public Rating update(Rating rating){
        log.info("Update in rating: {}",rating.getId());
        return rat.saveAndFlush(rating);
    }
    public void delete(Rating rating){
        log.info("Delete rating: {}",rating.getId());
        rat.delete(rating);
    }
    public List<Rating> readAll (){
        log.info("Read All rating");
        return rat.findAll();
    }
    public Rating readById (Long id){
        log.info("Read rating id: {}",id);
        Rating aux = rat.findById(id).get();
        if(aux == null){
            log.info("ID rating not found");
        }
        return aux;
    }
    public void deleteById(Long id){
        log.info("Delete rating id: {}",id);
        rat.deleteById(id);
        log.info("Deleted");
    }
}
