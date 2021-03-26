package com.romagnolocesar.foodz.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.romagnolocesar.foodz.domain.exception.EntidadeEmUsoException;
import com.romagnolocesar.foodz.domain.exception.EntidadeNaoEncontradaException;
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
		return restauranteRepository.findAll();
	}
	
	public Optional<Restaurante> buscar(Long restauranteId) {
		Optional<Restaurante> restaurante = restauranteRepository.findById(restauranteId);
		return restaurante;
		
	}
	
	public Restaurante salvar(Restaurante restaurante) {		
		return restauranteRepository.save(restaurante);
	}
	
	public ResponseEntity<?> atualizar(Long restauranteId, Restaurante restaurante){
		Optional<Restaurante> restauranteAtual = restauranteRepository.findById(restauranteId);
		
		if(restauranteAtual.isPresent()) {
			BeanUtils.copyProperties(restaurante, restauranteAtual, "id"); //Não copiar o campo ID, para manter o ID atual.
			restauranteRepository.save(restauranteAtual.get());

			return ResponseEntity.ok(restauranteAtual);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	public void remover(Long restauranteId) {
		try {
			restauranteRepository.deleteById(restauranteId);
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
