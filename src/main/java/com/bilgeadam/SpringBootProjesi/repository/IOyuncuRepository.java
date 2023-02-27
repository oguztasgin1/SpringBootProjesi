package com.bilgeadam.SpringBootProjesi.repository;

import com.bilgeadam.SpringBootProjesi.repository.entity.Oyuncu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IOyuncuRepository extends JpaRepository<Oyuncu, Long> {
    Optional<Oyuncu> findByAd(String ad);


    List<Oyuncu> findAllByOrderByPuanDesc();
}
