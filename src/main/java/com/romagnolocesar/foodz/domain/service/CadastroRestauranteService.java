package com.romagnolocesar.foodz.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.romagnolocesar.foodz.domain.exception.EntidadeEmUsoException;
import com.romagnolocesar.foodz.domain.exception.EntidadeNaoEncontradaException;
import com.romagnolocesar.foodz.domain.model.Cozinha;
import com.romagnolocesar.foodz.domain.model.Restaurante;
import com.romagnolocesar.foodz.domain.repository.CozinhaRepository;
import com.romagnolocesar.foodz.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {
	@Autowired
	RestauranteRepository restauranteRepository;
	
	@Autowired
	CozinhaRepository cozinhaRepository;
	
	public List<Restaurante> listar(){
		return restauranteRepository.listar();
	}
	
	public Restaurante buscar(Long restauranteId) {
		Restaurante restaurante = restauranteRepository.buscar(restauranteId);
		return restaurante;
		
	}
	
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
		
		if(cozinha == null) {
			throw new EntidadeNaoEncontradaException(
				String.format(
						"Não existe cadastro de cozinha com código %d",
						cozinhaId
				)
			);
		}
	
		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.salvar(restaurante);
	}
	
	public ResponseEntity<?> atualizar(Long restauranteId, Restaurante restaurante){
		Restaurante restauranteAtual = restauranteRepository.buscar(restauranteId);
		
		if(restauranteAtual != null) {
			BeanUtils.copyProperties(restaurante, restauranteAtual, "id"); //Não copiar o campo ID, para manter o ID atual.
			restauranteRepository.salvar(restauranteAtual);

			return ResponseEntity.ok(restauranteAtual);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	public void remover(Long restauranteId) {
		try {
			restauranteRepository.remover(restauranteId);
		} catch (EmptyResultDataAccessException e) {
			throw new 
			EntidadeNaoEncontradaException(
				String.format(
						"Não existe um cadastro de restaurante com código %d", 
						restauranteId
				)
			);
		} catch (DataIntegrityViolationException e) {
			throw new 
			EntidadeEmUsoException(
				String.format(
					"Restaurante de código %d não pode ser removido, pois está em uso.", 
					restauranteId
				)
			);
		}
	
	}
}
