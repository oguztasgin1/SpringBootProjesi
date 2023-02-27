package com.bilgeadam.SpringBootProjesi.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tbloyuncu")
@Getter
@Setter
public class Oyuncu extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String ad;

    String avatar;

    int puan;

    int hak = 5;

    @ManyToOne
    private Soru soru;
}
