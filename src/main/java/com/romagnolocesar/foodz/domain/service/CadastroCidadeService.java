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
import com.romagnolocesar.foodz.domain.model.Cidade;
import com.romagnolocesar.foodz.domain.model.Estado;
import com.romagnolocesar.foodz.domain.repository.CidadeRepository;
import com.romagnolocesar.foodz.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	public List<Cidade> listar(){
		return cidadeRepository.listar();
	}
	
	public Cidade buscar(Long cidadeId) {
		Cidade cidades = cidadeRepository.buscar(cidadeId);
		return cidades;	
	}
	
	public Cidade salvar(Cidade cidade){
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.buscar(estadoId);
		
		if(estado == null) {
			throw new EntidadeNaoEncontradaException(
					String.format(
							"Não existe cadastro de estado com código %d",
							estadoId
					)
				);
		}
	
		cidade.setEstado(estado);
		
		return cidadeRepository.salvar(cidade);
	}
	
	public ResponseEntity<Cidade> atualizar(Long cidadeId, Cidade cidade){
		Cidade cidadeAtual = cidadeRepository.buscar(cidadeId);
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.buscar(estadoId);
		
		if(estado == null) {
			throw new EntidadeNaoEncontradaException(
					String.format(
							"Não existe cadastro de estado com código %d",
							estadoId
					)
				);
		}
	
		cidade.setEstado(estado);
		
		if(cidadeAtual != null) {
			BeanUtils.copyProperties(cidade, cidadeAtual, "id"); //Não copiar o campo ID, para manter o ID atual.
			cidadeRepository.salvar(cidadeAtual);

			return ResponseEntity.ok(cidadeAtual);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	public void remover(Long cidadeId) {
		try {
			cidadeRepository.remover(cidadeId);
		} catch (EmptyResultDataAccessException e) {
			throw new 
			EntidadeNaoEncontradaException(
				String.format(
						"Não existe um cadastro de cidade com código %d", 
						cidadeId
				)
			);
		} catch (DataIntegrityViolationException e) {
			throw new 
			EntidadeEmUsoException(
				String.format(
					"Cidade de código %d não pode ser removida, pois está em uso.", 
					cidadeId
				)
			);
		}
	
	}
	

}
