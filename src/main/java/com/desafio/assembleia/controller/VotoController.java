package com.desafio.assembleia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.assembleia.model.Associado;
import com.desafio.assembleia.model.Sessao;
import com.desafio.assembleia.model.Voto;
import com.desafio.assembleia.repository.AssociadoRepository;
import com.desafio.assembleia.repository.VotoRepository;
import com.desafio.assembleia.service.RetornoOpcaoVoto;

@RestController
@RequestMapping("/sessao")
public class VotoController {
	
	@Autowired
	private VotoRepository votoRepository;
	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	@PostMapping
	public void adicionaVoto(RetornoOpcaoVoto request, Associado associado, Sessao sessao) {
		Voto voto = request.toVoto(sessao);
		
		voto.checaSeAssociadoJaVotou(associado);
		
	}
	
}
