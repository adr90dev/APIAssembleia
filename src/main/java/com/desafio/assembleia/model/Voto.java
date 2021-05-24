package com.desafio.assembleia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.util.Assert;

import com.desafio.assembleia.service.OpcaoVoto;

@Entity
public class Voto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private OpcaoVoto opcaoVoto;

	@ManyToOne
	private Sessao sessao;

	@OneToOne
	private Associado idAssociado;

	@ManyToOne
	private Pauta pauta;

	public Voto(Long id, OpcaoVoto opcaoVoto, Sessao sessao, Associado idAssociado, Pauta pauta) {
		this.id = id;
		this.opcaoVoto = opcaoVoto;
		this.sessao = sessao;
		this.idAssociado = idAssociado;
		this.pauta = pauta;
	}

	public Long getId() {
		return id;
	}

	public OpcaoVoto getOpcaoVoto() {
		return opcaoVoto;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public Associado getAssociado() {
		return idAssociado;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void checaSeAssociadoJaVotou(Associado associado) {

		Assert.isTrue(!associado.getId().equals(idAssociado), 
				"Esse Associado já votou nessa sessão " + sessao);

	}
}
