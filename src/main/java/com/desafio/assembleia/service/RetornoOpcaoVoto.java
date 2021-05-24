package com.desafio.assembleia.service;

import com.desafio.assembleia.model.Sessao;
import com.desafio.assembleia.model.Voto;

public interface RetornoOpcaoVoto {

	Voto toVoto (Sessao sessao);
	
}
