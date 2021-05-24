package com.desafio.assembleia.request;

import javax.validation.constraints.NotBlank;

import com.desafio.assembleia.service.OpcaoVoto;
import com.sun.istack.NotNull;

public class NovaVotacaoRequest {

	
	@NotNull
	private Long idPauta;
	
	@NotNull
	private Long idAssociado;
	
	@NotBlank
	private OpcaoVoto voto;

	public NovaVotacaoRequest(Long idPauta, Long idAssociado, OpcaoVoto voto) {
		this.idPauta = idPauta;
		this.idAssociado = idAssociado;
		this.voto = voto;
	}
	
	@Override
	public String toString() {
		return "NovaVotacaoRequest [idPauta=" + idPauta
				+ ", idAssociado=" + idAssociado
				+ ", voto=" + voto
				+ "]";
	}
	
}
