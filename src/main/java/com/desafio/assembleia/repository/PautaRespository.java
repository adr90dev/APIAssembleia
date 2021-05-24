package com.desafio.assembleia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.assembleia.model.Pauta;

@Repository
public interface PautaRespository extends JpaRepository<Pauta, Long>{

}
