package com.desafio.assembleia.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

import com.desafio.assembleia.request.NovaVotacaoRequest;
import com.desafio.assembleia.service.OpcaoVoto;

@Entity
public class Sessao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Pauta pauta;
	
	private Associado associado;
	
	private OpcaoVoto opcaoVoto;
	
	private Set<Voto> votos = new HashSet<>();
	
	public Sessao (Pauta pauta, Associado associado, OpcaoVoto opcaoVoto, Set<Voto> votos) {
		this.pauta = pauta;
		this.associado = associado;
		this.opcaoVoto = opcaoVoto;
		this.votos = votos;
	}

	public Long getId() {
		return id;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public Associado getAssociado() {
		return associado;
	}

	public OpcaoVoto getOpcaoVoto() {
		return opcaoVoto;
	}
	
	public Set<Voto> getVotos() {
		return votos;
	}
	
	public void novaVotacao(@RequestBody @Valid NovaVotacaoRequest request) throws InterruptedException {
		System.out.println("Iniciando Votacão " + request);
		Thread.sleep(150);
	}
	
//	public void adicionaVoto(RetornoOpcaoVoto request, Associado associado) {
//		Voto voto = request.toVoto(this);
//		
//		this.votos.add(voto);
//	}
}
