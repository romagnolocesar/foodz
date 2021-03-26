package com.romagnolocesar.foodz.domain.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.romagnolocesar.foodz.domain.exception.EntidadeEmUsoException;
import com.romagnolocesar.foodz.domain.exception.EntidadeNaoEncontradaException;
import com.romagnolocesar.foodz.domain.model.Estado;
import com.romagnolocesar.foodz.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {
	
	@Autowired
	EstadoRepository estadoRespository;
	
	public Estado salvar(Estado estado) {
		return estadoRespository.save(estado);
	}
	
	public ResponseEntity<?> atualizar(Long estadoId, Estado estado){
		Optional<Estado> estadoAtual = estadoRespository.findById(estadoId);
		
		if(estadoAtual != null) {
			BeanUtils.copyProperties(estado, estadoAtual, "id"); //Não copiar o campo ID, para manter o ID atual.
			estadoRespository.save(estadoAtual.get());

			return ResponseEntity.ok(estadoAtual);
		}
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(String.format(
						"Não existe cadastro de estado com código %d",
						estadoId));
	}

	public void remover(Long estadoId) {
		try {
				estadoRespository.deleteById(estadoId);
		} catch (EmptyResultDataAccessException e) {
			throw new 
			EntidadeNaoEncontradaException(
				String.format(
						"Não existe um cadastro de estado com código %d", 
						estadoId
				)
			);
		} catch (DataIntegrityViolationException e) {
			throw new 
			EntidadeEmUsoException(
				String.format(
					"Estado de código %d não pode ser removida, pois está em uso.", 
					estadoId
				)
			);
		}
	
	}
	
	
}
