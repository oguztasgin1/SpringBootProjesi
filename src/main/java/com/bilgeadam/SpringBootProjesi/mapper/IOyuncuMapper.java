package com.bilgeadam.SpringBootProjesi.mapper;

import com.bilgeadam.SpringBootProjesi.dto.request.OyuncuOlusturRequestDto;
import com.bilgeadam.SpringBootProjesi.dto.response.OyuncuLoginResponseDto;
import com.bilgeadam.SpringBootProjesi.repository.entity.Oyuncu;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IOyuncuMapper {
    IOyuncuMapper INSTANCE = Mappers.getMapper(IOyuncuMapper.class);

    Oyuncu toOyuncu(final OyuncuOlusturRequestDto dto);

    OyuncuLoginResponseDto toOyuncuLoginResponse(final Oyuncu oyuncu);
}
