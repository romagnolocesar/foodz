package com.romagnolocesar.foodz.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.romagnolocesar.foodz.domain.exception.EntidadeEmUsoException;
import com.romagnolocesar.foodz.domain.exception.EntidadeNaoEncontradaException;
import com.romagnolocesar.foodz.domain.model.Cidade;
import com.romagnolocesar.foodz.domain.model.Cozinha;
import com.romagnolocesar.foodz.domain.model.Estado;
import com.romagnolocesar.foodz.domain.model.Restaurante;
import com.romagnolocesar.foodz.domain.repository.CozinhaRepository;
import com.romagnolocesar.foodz.domain.repository.RestauranteRepository;
import com.romagnolocesar.foodz.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
	
	@Autowired
	RestauranteRepository restauranteRepository;
	
	@Autowired
	CozinhaRepository cozinhaRepository;
	
	@Autowired
	CadastroRestauranteService cadastroRestauranteService;
	
	@GetMapping
	public List<Restaurante> listar() {
		return restauranteRepository.findAll(); 
	}
	
	@GetMapping("/{restauranteId}")
	public ResponseEntity<?> buscar(@PathVariable Long restauranteId){
		Optional<Restaurante> restaurante = restauranteRepository.findById(restauranteId);
		
		if(restaurante.isPresent()) {
			return ResponseEntity.ok(restaurante.get());			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(String.format(
						"Não existe cadastro de restaurante com código %d",
						restauranteId));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> salvar(@RequestBody Restaurante restaurante) {
		Optional<Cozinha> cozinha = Optional.ofNullable(restaurante.getCozinha());
		
		if(cozinha.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("O campo cozinha é obrigatório.");
		}else {
			cozinha = cozinhaRepository.findById(restaurante.getCozinha().getId());
			if(cozinha.isEmpty()) {
				return ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.body(
							String.format(
								"Não existe cadastro de cozinha com código %d", restaurante.getCozinha().getId()
							)
						);
			}	
			
		}
		try{
			restaurante = cadastroRestauranteService.salvar(restaurante);
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(restaurante);
		}catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());	
		}
	}
	
	@PutMapping("/{restauranteId}")
	public ResponseEntity<?> atualizar(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {
		Optional<Restaurante> restauranteAtual = restauranteRepository.findById(restauranteId);
		Optional<Cozinha> cozinhaNova = Optional.ofNullable(restaurante.getCozinha());
		
		if(cozinhaNova.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("O campo cozinha é obrigatório.");
		}else {
			Optional<Cozinha> cozinha = cozinhaRepository.findById(restaurante.getCozinha().getId());
			if(cozinha.isEmpty()) {
				return ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.body(
							String.format(
								"Não existe cadastro de cozinha com código %d", restaurante.getCozinha().getId()
							)
						);
			}	
			restaurante.setCozinha(cozinha.get());
		}
		
		
		if(restauranteAtual.isPresent()) {
			BeanUtils.copyProperties(restaurante, restauranteAtual.get(), "id");
			Restaurante cozinhaSalva = cadastroRestauranteService.salvar(restauranteAtual.get());
			return ResponseEntity.ok(cozinhaSalva);

		}
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(String.format(
						"Não existe cadastro de restaurante com código %d",
						restauranteId));
	}
	
	@DeleteMapping("/{restauranteId}")
	public ResponseEntity<?> remover(@PathVariable Long restauranteId) {
		try {
			cadastroRestauranteService.remover(restauranteId);
			return ResponseEntity.noContent().build();
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}catch(EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
	@PatchMapping("/{restauranteId}")
	public ResponseEntity<?> atualizarParcial(@PathVariable Long restauranteId, 
			@RequestBody Map<String, Object> campos){
		
		Restaurante restauranteAtual = restauranteRepository.findById(restauranteId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(
							"Não existe cadastro de restaurante com código %d",
							restauranteId)));
				
		merge(campos, restauranteAtual);
		
		return atualizar(restauranteId, restauranteAtual);
	}

	private void merge(Map<String, Object> dadosOrigem, Restaurante restauranteDestino) {
		ObjectMapper objectMapper = new ObjectMapper();
		Restaurante restauranteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class);
		
		
		dadosOrigem.forEach((nomePropriedade, valorPropriedade) ->{
			Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
			field.setAccessible(true);
			
			Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);
			
			ReflectionUtils.setField(field, restauranteDestino, novoValor);
			
		});
	}
}
