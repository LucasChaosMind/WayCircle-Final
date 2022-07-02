package com.project.waycircle.model;

import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity @NoArgsConstructor @AllArgsConstructor @Builder
public class Stock {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Type(type = "long") @Getter
    private Long id;
    @Getter @Setter
    private Integer quantity;
    @Getter @Setter @Nullable
    private LocalDateTime lastModified;
}
