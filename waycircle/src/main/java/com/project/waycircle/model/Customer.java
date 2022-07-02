package com.project.waycircle.model;

import com.project.waycircle.model.enums.Gender;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity  @NoArgsConstructor @AllArgsConstructor @Builder
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Type(type = "long")
    private Long id;
    @Getter @Setter
    private String name;
    @Getter
    private String cpf;
    @Getter
    private Gender gender;
    @OneToOne
    private Address address;
}
