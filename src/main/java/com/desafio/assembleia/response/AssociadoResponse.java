package com.desafio.assembleia.response;

import com.desafio.assembleia.model.Associado;

public class AssociadoResponse {

	private String nome;
	
	public AssociadoResponse(Associado associado) {
		this.nome = associado.getNome();
	}

	public String getNome() {
		return nome;
	}
}
