package com.bilgeadam.SpringBootProjesi.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OyuncuLoginResponseDto {
    String ad;

    String avatar;

    int puan;

    int hak;

    boolean state;
}
