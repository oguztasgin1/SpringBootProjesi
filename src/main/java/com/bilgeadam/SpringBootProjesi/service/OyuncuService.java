package com.bilgeadam.SpringBootProjesi.service;

import com.bilgeadam.SpringBootProjesi.dto.request.OyuncuLoginRequestDto;
import com.bilgeadam.SpringBootProjesi.dto.request.OyuncuOlusturRequestDto;
import com.bilgeadam.SpringBootProjesi.dto.response.OyuncuLoginResponseDto;
import com.bilgeadam.SpringBootProjesi.mapper.IOyuncuMapper;
import com.bilgeadam.SpringBootProjesi.repository.IOyuncuRepository;
import com.bilgeadam.SpringBootProjesi.repository.entity.Oyuncu;
import com.bilgeadam.SpringBootProjesi.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OyuncuService extends ServiceManager<Oyuncu, Long> {
    private final IOyuncuRepository oyuncuRepository;

    public OyuncuService(IOyuncuRepository oyuncuRepository){
        super(oyuncuRepository);
        this.oyuncuRepository= oyuncuRepository;
    }

    public void oyuncuOlustur(OyuncuOlusturRequestDto dto) {
        Oyuncu oyuncu = IOyuncuMapper.INSTANCE.toOyuncu(dto);
        Optional<Oyuncu> oyuncu1 = oyuncuRepository.findByAd(oyuncu.getAd());
        if (oyuncu1.isEmpty()){
            save(oyuncu);
        }
    }

    public OyuncuLoginResponseDto login(OyuncuLoginRequestDto dto) {
        Optional<Oyuncu> oyuncu = oyuncuRepository.findByAd(dto.getAd());
        if(oyuncu.isPresent()){
            return IOyuncuMapper.INSTANCE.toOyuncuLoginResponse(oyuncu.get());
        }
        else{
            throw new RuntimeException("Kullanici bulunaadi");
        }
    }

    public List<Oyuncu> findAllByOrderByPuanDesc() {
        return oyuncuRepository.findAllByOrderByPuanDesc();
    }
}
