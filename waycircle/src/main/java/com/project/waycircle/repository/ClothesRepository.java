package com.project.waycircle.repository;

import com.project.waycircle.model.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClothesRepository  extends JpaRepository<Clothes, Long> {

}
