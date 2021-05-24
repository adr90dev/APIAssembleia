package com.desafio.assembleia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.assembleia.model.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long>{

}
