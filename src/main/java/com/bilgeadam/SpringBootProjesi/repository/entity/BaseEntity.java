package com.bilgeadam.SpringBootProjesi.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseEntity {
    boolean state;
    Long createdate;
    Long updatedate;
}
