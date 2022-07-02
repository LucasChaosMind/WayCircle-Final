package com.project.waycircle.service.useCases;

import com.project.waycircle.model.Clothes;
import com.project.waycircle.model.Rating;
import com.project.waycircle.service.CRUD.ClothesServiceCRUD;
import com.project.waycircle.service.CRUD.RatingServiceCRUD;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service @Slf4j
public record RatingService(ClothesServiceCRUD clothesServiceCRUD, RatingServiceCRUD ratingServiceCRUD) {

    public Rating saveNewRating(Clothes cl, Rating ra){
        log.info("Salvando avaliação {} de {}",ra.getId(),ra.getCliente().getName());
        Rating raAdd = ratingServiceCRUD.save(ra);
        if(raAdd == null){
            log.info("Erro ao atualizar Avalaicao no Banco de Dados:{} {}", ra.getId(),ra.getCliente().getName());
        }
        cl.getRatings().add(ra);
        Clothes clAdd = clothesServiceCRUD.update(cl);
        if(clAdd == null){
            log.info("Erro ao atualizar roupa no Banco de Dados: {}",cl.getName());
        }
        return raAdd;
    }
}
