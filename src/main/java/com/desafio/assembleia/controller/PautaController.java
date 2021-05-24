package com.desafio.assembleia.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.assembleia.model.Pauta;
import com.desafio.assembleia.repository.PautaRespository;
import com.desafio.assembleia.request.NovaPautaRequest;
import com.desafio.assembleia.response.PautaResponse;

@RestController
@RequestMapping("/pautas")
public class PautaController {

	@Autowired
	private PautaRespository pautaRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastraPauta(@RequestBody @Valid NovaPautaRequest request) {
		Pauta pauta = request.toPauta();
		pautaRepository.save(pauta);

		PautaResponse response = new PautaResponse(pauta);
		return ResponseEntity.ok(response);
	}

	@GetMapping
	public ResponseEntity<?> listaPauta() {
		List<Pauta> pauta = pautaRepository.findAll();

		return ResponseEntity.ok(pauta);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> listaPorId(@PathVariable("id") Long id) {
		Optional<Pauta> pauta = pautaRepository.findById(id);

		return ResponseEntity.ok(pauta);
	}
	
	@PutMapping
	public ResponseEntity<Pauta> put (@RequestBody Pauta postagem){
		return ResponseEntity.status(HttpStatus.OK).body(pautaRepository.save(postagem));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		pautaRepository.deleteById(id);
	}
}