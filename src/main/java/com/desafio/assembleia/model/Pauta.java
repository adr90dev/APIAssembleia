package com.desafio.assembleia.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pauta {

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

	@Deprecated
	public Pauta() {

	}

	public Pauta(@NotBlank String nomeQuemAbriu, @NotBlank LocalDateTime dataDeAbertura, @NotBlank String tema,
			@NotBlank String historico) {
		this.nomeQuemAbriu = nomeQuemAbriu;
		this.dataDeAbertura = dataDeAbertura;
		this.tema = tema;
		this.historico = historico;
	}

	public Long getId() {
		return id;
	}

	public String getTema() {
		return tema;
	}

	public String getHistorico() {
		return historico;
	}

	public LocalDateTime getDataDeAbertura() {
		return dataDeAbertura;
	}

	public String getNomeQuemAbriu() {
		return nomeQuemAbriu;
	}

}
