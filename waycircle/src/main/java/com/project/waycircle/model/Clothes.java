package com.project.waycircle.model;

import com.project.waycircle.model.enums.Size;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Builder
public class Clothes {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Type(type = "long")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(precision = 2, nullable = false)
    private Double value;
    @OneToMany
    private List<Rating> ratings;
    @OneToOne @Getter @Setter
    private Stock stock;
    private Size size;
}
