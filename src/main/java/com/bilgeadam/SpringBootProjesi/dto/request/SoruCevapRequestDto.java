package com.bilgeadam.SpringBootProjesi.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SoruCevapRequestDto {
    Long soruid;
    Long oyuncuid;
    String oyuncucevap;

}
