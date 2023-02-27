package com.bilgeadam.SpringBootProjesi.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tblsoru")
@Getter
@Setter
public class Soru extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String konu;

    String soruicerik;

    String image;

    String cevap;

    String dogrucevap;

    int puan;

    boolean sonuc = false;

    @OneToMany(mappedBy = "soru", fetch = FetchType.LAZY)
    private List<Oyuncu> oyuncular;

}
