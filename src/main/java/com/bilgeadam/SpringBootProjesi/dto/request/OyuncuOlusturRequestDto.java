package com.bilgeadam.SpringBootProjesi.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OyuncuOlusturRequestDto {
    String ad;
    boolean state;
}
