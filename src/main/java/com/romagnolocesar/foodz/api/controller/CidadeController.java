package com.romagnolocesar.foodz.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.romagnolocesar.foodz.domain.exception.EntidadeNaoEncontradaException;
import com.romagnolocesar.foodz.domain.model.Cidade;
import com.romagnolocesar.foodz.domain.model.Estado;
import com.romagnolocesar.foodz.domain.model.Restaurante;
import com.romagnolocesar.foodz.domain.repository.CidadeRepository;
import com.romagnolocesar.foodz.domain.repository.EstadoRepository;
import com.romagnolocesar.foodz.domain.repository.RestauranteRepository;
import com.romagnolocesar.foodz.domain.service.CadastroCidadeService;

@RestController
@RequestMapping(value="/cidades", produces = MediaType.APPLICATION_JSON_VALUE)
public class CidadeController {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CadastroCidadeService cadastroCidadeService;
	
	@GetMapping
	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}

	@GetMapping("/{cidadeId}")
	public ResponseEntity<?> buscar(@PathVariable Long cidadeId) {
		Optional<Cidade> cidade = cidadeRepository.findById(cidadeId);
		
		if (cidade.isPresent()) {
			return ResponseEntity.ok(cidade.get());
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(String.format(
						"Não existe cadastro de cidade com código %d",
						cidadeId));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> salvar(@RequestBody Cidade cidade) {
		Optional<Estado> estado = Optional.ofNullable(cidade.getEstado());
		
		if(estado.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("O campo estado é obrigatório.");
		}else {
			estado = estadoRepository.findById(cidade.getEstado().getId());
			if(estado.isEmpty()) {
				return ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.body(
							String.format(
								"Não existe cadastro de estado com código %d", cidade.getEstado().getId()
							)
						);
			}	
			
		}
		
		try {
			cidade = cadastroCidadeService.salvar(cidade);
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(cidade);
		}catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());	
		}
	}
	
	@PutMapping("/{cidadeId}")
	public ResponseEntity<?> atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade){
		Optional<Cidade> cidadeAtual = cidadeRepository.findById(cidadeId);
		Optional<Estado> estadoNovo = Optional.ofNullable(cidade.getEstado());
		
		if(estadoNovo.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("O campo estado é obrigatório.");
		}else {
			Optional<Estado> estado = estadoRepository.findById(cidade.getEstado().getId());
			if(estado.isEmpty()) {
				return ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.body(
							String.format(
								"Não existe cadastro de estado com código %d", cidade.getEstado().getId()
							)
						);
			}	
			cidade.setEstado(estado.get());
		}
		
		
		
		if(cidadeAtual.isPresent()) {
			BeanUtils.copyProperties(cidade, cidadeAtual.get(), "id");
			Cidade cidadeSalva = cadastroCidadeService.salvar(cidadeAtual.get());
			return ResponseEntity.ok(cidadeSalva);
		}
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(String.format(
						"Não existe cadastro de cidade com código %d",
						cidadeId));
	}
	
	@DeleteMapping("/{cidadeId}")
	public ResponseEntity<?> remover(@PathVariable Long cidadeId){
		try {
			cadastroCidadeService.remover(cidadeId);
			return ResponseEntity.noContent().build();
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	
}
