package com.desafio.assembleia.request;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.desafio.assembleia.model.Pauta;

public class NovaPautaRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nomeQuemAbriu;

	@NotBlank
	private LocalDateTime dataDeAbertura = LocalDateTime.now();

	@NotBlank
	private String tema;

	@NotBlank
	private String historico;

	public Long getId() {
		return id;
	}

	public String getTema() {
		return tema;
	}

	public String getHistorico() {
		return historico;
	}

	public Pauta toPauta() {
		return new Pauta(nomeQuemAbriu, dataDeAbertura, tema, historico);
	}

	public String getNomeQuemAbriu() {
		return nomeQuemAbriu;
	}

	public LocalDateTime getDataDeAbertura() {
		return dataDeAbertura;
	}
}
