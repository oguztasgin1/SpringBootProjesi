package com.bilgeadam.SpringBootProjesi.controller;

import com.bilgeadam.SpringBootProjesi.dto.request.SoruCevapRequestDto;
import com.bilgeadam.SpringBootProjesi.dto.request.SoruOlusturRequestDto;
import com.bilgeadam.SpringBootProjesi.dto.response.ResultDto;
import com.bilgeadam.SpringBootProjesi.dto.response.SoruCevapResponseDto;
import com.bilgeadam.SpringBootProjesi.repository.entity.Soru;
import com.bilgeadam.SpringBootProjesi.service.SoruService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.bilgeadam.SpringBootProjesi.constant.EndPoints.*;

@RestController
@RequestMapping(VERSION+API+SORU)
@RequiredArgsConstructor
public class SoruController {
    private final SoruService soruService;

    @PostMapping(SORUOLUSTUR)
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> soruOlustur(@RequestBody SoruOlusturRequestDto dto){
        soruService.soruOlustur(dto);
        return ResponseEntity.ok(ResultDto.builder().state(true).build());
    }

    @GetMapping(FINDBYID)
    public ResponseEntity<?> findById(Long id) {
        Optional<Soru> soru = soruService.findById(id);
        if (soru.isEmpty()) throw new RuntimeException("Soru bulunamadi");
        return ResponseEntity.ok(ResultDto.builder().state(true).build());
    }
    @PostMapping(CEVAPVER)
    public SoruCevapResponseDto cevapVer(SoruCevapRequestDto soruCevapRequestDto){
        return soruService.cevapVer(soruCevapRequestDto);
    }

}
