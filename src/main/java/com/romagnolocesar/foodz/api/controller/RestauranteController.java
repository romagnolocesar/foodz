package com.romagnolocesar.foodz.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.romagnolocesar.foodz.domain.exception.EntidadeNaoEncontradaException;
import com.romagnolocesar.foodz.domain.model.Cozinha;
import com.romagnolocesar.foodz.domain.model.Restaurante;
import com.romagnolocesar.foodz.domain.repository.RestauranteRepository;
import com.romagnolocesar.foodz.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
	
	@Autowired
	RestauranteRepository restauranteRepository;
	
	@Autowired
	CadastroRestauranteService cadastroRestauranteService;
	
	@GetMapping
	public List<Restaurante> listar() {
		return cadastroRestauranteService.listar(); 
	}
	
	@GetMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId){
		Restaurante restaurante = cadastroRestauranteService.buscar(restauranteId);
		
		if(restaurante != null) {
			return ResponseEntity.ok(restaurante);			
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> salvar(@RequestBody Restaurante restaurante) {
		try{
			restaurante = cadastroRestauranteService.salvar(restaurante);
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(restaurante);
		}catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());	
		}
	}
}
