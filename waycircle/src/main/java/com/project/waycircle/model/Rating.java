package com.project.waycircle.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity @NoArgsConstructor @AllArgsConstructor
@Builder @Getter
public class Rating {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Type(type = "long")
    private Long id;

    private String desc;

    private Integer stars;
    @OneToOne
    private Customer cliente;
}
