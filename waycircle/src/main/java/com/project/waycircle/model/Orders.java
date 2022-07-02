package com.project.waycircle.model;

import com.project.waycircle.model.enums.Pay;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity  @NoArgsConstructor @AllArgsConstructor
@Builder
public class Orders {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Type(type = "long") @Getter
    private Long id;
    @ManyToOne @Getter @Setter
    private Customer customer;
    @OneToMany @Getter @Setter
    private List<Clothes> clothes;
    @Getter @Setter
    private Pay payType;
    @Getter @Setter
    private Double ValorTotal;
    @Setter @Getter
    private boolean isPay = false;
}
