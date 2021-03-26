package com.romagnolocesar.foodz.domain.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.romagnolocesar.foodz.domain.exception.EntidadeEmUsoException;
import com.romagnolocesar.foodz.domain.exception.EntidadeNaoEncontradaException;
import com.romagnolocesar.foodz.domain.model.Cozinha;
import com.romagnolocesar.foodz.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {
	
	@Autowired
	CozinhaRepository cozinhaRepository;
		
	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}
	
	public ResponseEntity<?> atualizar(Long cozinhaId, Cozinha cozinha){
		Optional<Cozinha> cozinhaAtual = cozinhaRepository.findById(cozinhaId);
		
		if(cozinhaAtual.isPresent()) {
			cozinhaAtual = Optional.ofNullable(cozinhaAtual.get());
			BeanUtils.copyProperties(cozinha, cozinhaAtual.get(), "id"); //Não copiar o campo ID, para manter o ID atual.
			cozinhaRepository.save(cozinhaAtual.get());

			return ResponseEntity.ok(cozinhaAtual.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	public void remover(Long cozinhaId) {
		try {
				cozinhaRepository.deleteById(cozinhaId);
		} catch (EmptyResultDataAccessException e) {
			throw new 
			EntidadeNaoEncontradaException(
				String.format(
						"Não existe um cadastro de cozinha com código %d", 
						cozinhaId
				)
			);
		} catch (DataIntegrityViolationException e) {
			throw new 
			EntidadeEmUsoException(
				String.format(
					"Cozinha de código %d não pode ser removida, pois está em uso.", 
					cozinhaId
				)
			);
		}
	
	}
}
