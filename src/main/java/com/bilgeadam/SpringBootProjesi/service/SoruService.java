package com.bilgeadam.SpringBootProjesi.service;

import com.bilgeadam.SpringBootProjesi.dto.request.SoruCevapRequestDto;
import com.bilgeadam.SpringBootProjesi.dto.request.SoruOlusturRequestDto;
import com.bilgeadam.SpringBootProjesi.dto.response.SoruCevapResponseDto;
import com.bilgeadam.SpringBootProjesi.mapper.ISoruMapper;
import com.bilgeadam.SpringBootProjesi.repository.ISoruRepository;
import com.bilgeadam.SpringBootProjesi.repository.entity.Oyuncu;
import com.bilgeadam.SpringBootProjesi.repository.entity.Soru;
import com.bilgeadam.SpringBootProjesi.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoruService extends ServiceManager<Soru, Long> {
    private final ISoruRepository soruRepository;

    public SoruService(ISoruRepository soruRepository, OyuncuService oyuncuService) {
        super(soruRepository);
        this.soruRepository = soruRepository;
    }

    public void soruOlustur(SoruOlusturRequestDto dto) {
        save(ISoruMapper.INSTANCE.toSoru(dto));
    }

    public SoruCevapResponseDto cevapVer(SoruCevapRequestDto soruCevapRequestDto) {
        Optional<Soru> soru = soruRepository.findById(soruCevapRequestDto.getSoruid());
        List<Oyuncu> oyuncular = soru.get().getOyuncular();
        if (soru.get().getDogrucevap().equalsIgnoreCase(soruCevapRequestDto.getOyuncucevap())){
            for (Oyuncu oyuncu1 : oyuncular){
                if (oyuncu1.getId()==soruCevapRequestDto.getOyuncuid()){
                    oyuncu1.setPuan(oyuncu1.getPuan() + soru.get().getPuan());
                }
            }
            soru.get().setSonuc(true);
            return ISoruMapper.INSTANCE.toSoruCevapResponseDto(soru);
        }
        else{
            for (Oyuncu oyuncu1 : oyuncular) {
                if (oyuncu1.getId()==soruCevapRequestDto.getOyuncuid()){
                    oyuncu1.setHak(oyuncu1.getHak() - 1);
                }
            }
        }
        throw new RuntimeException("Soru cevabı yanlis");
    }
}
