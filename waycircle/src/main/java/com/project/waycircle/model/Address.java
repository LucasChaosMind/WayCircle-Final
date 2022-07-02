package com.project.waycircle.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity @NoArgsConstructor @AllArgsConstructor
@Getter @Builder
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Type(type = "long")
    private Long id;
    private String zipCode;
    private String city;
    private String street;
    private String number;
}
