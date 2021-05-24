package com.desafio.assembleia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.assembleia.model.Associado;
import com.desafio.assembleia.repository.AssociadoRepository;
import com.desafio.assembleia.request.NovoAssociadoRequest;
import com.desafio.assembleia.response.AssociadoResponse;

@RestController
@RequestMapping("/associados")
public class AssociadoController {

	@Autowired
	private AssociadoRepository associadoRepository;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(NovoAssociadoRequest request){
		Associado associado = request.toAssociado();
		associadoRepository.save(associado);
		
		AssociadoResponse response = new AssociadoResponse(associado);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Associado> associado = associadoRepository.findAll();

		return ResponseEntity.ok(associado);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> listaPorId(@PathVariable("id") Long id) {
		Optional<Associado> associado = associadoRepository.findById(id);

		return ResponseEntity.ok(associado);
	}
	
	@PutMapping
	public ResponseEntity<Associado> atualizar (@RequestBody Associado associado){
		return ResponseEntity.status(HttpStatus.OK).body(associadoRepository.save(associado));
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable long id) {
		associadoRepository.deleteById(id);
	}
}
