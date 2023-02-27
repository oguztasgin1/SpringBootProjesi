package com.bilgeadam.SpringBootProjesi.controller;

import com.bilgeadam.SpringBootProjesi.dto.request.OyuncuLoginRequestDto;
import com.bilgeadam.SpringBootProjesi.dto.request.OyuncuOlusturRequestDto;
import com.bilgeadam.SpringBootProjesi.dto.response.OyuncuLoginResponseDto;
import com.bilgeadam.SpringBootProjesi.repository.entity.Oyuncu;
import com.bilgeadam.SpringBootProjesi.service.OyuncuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bilgeadam.SpringBootProjesi.constant.EndPoints.*;

@RestController
@RequestMapping(VERSION+API+SORU)
@RequiredArgsConstructor
public class OyuncuController {
    private final OyuncuService oyuncuService;

    @GetMapping(OYUNCUOLUSTUR)
    public ResponseEntity<OyuncuOlusturRequestDto> oyuncuOlustur(OyuncuOlusturRequestDto dto){
        oyuncuService.oyuncuOlustur(dto);
        return ResponseEntity.ok(OyuncuOlusturRequestDto.builder().state(true).build());
    }

    @PostMapping(LOGIN)
    public ResponseEntity<OyuncuLoginResponseDto> oyuncuLogin(@RequestBody OyuncuLoginRequestDto dto){
        oyuncuService.login(dto);
        return ResponseEntity.ok(OyuncuLoginResponseDto.builder().state(true).build());
    }

    @GetMapping(SIRALAMA)
    public void findAll(){
        List<Oyuncu> siralanmisListe = oyuncuService.findAllByOrderByPuanDesc();
        System.out.println(siralanmisListe.toString());
    }

}
