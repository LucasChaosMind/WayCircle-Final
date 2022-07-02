package com.project.waycircle.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity @NoArgsConstructor @AllArgsConstructor
public class SaleReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) @Type(type = "long")@Getter
    private Long id;
    @OneToMany @Setter @Getter
    private List<Orders> buy;
    @Setter @Getter
    private LocalDate date;
    @Setter @Getter
    private Double totalAmountSales;
}
