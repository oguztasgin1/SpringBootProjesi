package com.bilgeadam.SpringBootProjesi.mapper;


import com.bilgeadam.SpringBootProjesi.dto.request.SoruOlusturRequestDto;
import com.bilgeadam.SpringBootProjesi.dto.response.SoruCevapResponseDto;
import com.bilgeadam.SpringBootProjesi.repository.entity.Soru;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ISoruMapper {

    ISoruMapper INSTANCE = Mappers.getMapper(ISoruMapper.class);


    Soru toSoru(final SoruOlusturRequestDto dto);

    SoruCevapResponseDto toSoruCevapResponseDto(final Optional<Soru> soru);
}
