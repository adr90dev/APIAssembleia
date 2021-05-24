package com.desafio.assembleia.response;

import com.desafio.assembleia.model.Pauta;

public class PautaResponse {

	private String tema;
	
	private String historico;
	
	public PautaResponse(Pauta pauta) {
		this.tema = pauta.getTema();
		this.historico = pauta.getHistorico();
	}

	public String getTema() {
		return tema;
	}

	public String getHistorico() {
		return historico;
	}
	
}
