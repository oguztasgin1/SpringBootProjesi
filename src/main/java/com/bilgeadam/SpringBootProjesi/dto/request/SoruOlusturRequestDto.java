package com.bilgeadam.SpringBootProjesi.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SoruOlusturRequestDto {
    String konu;

    String soruicerik;

    String image;

    String cevap;

    String dogrucevap;

    int puan;
}
