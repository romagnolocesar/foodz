package com.romagnolocesar.foodz.domain.service;

import java.util.List;
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
		return cidadeRepository.findAll();
	}
	
	public Cidade buscar(Long cidadeId) {
		Cidade cidades = cidadeRepository.findById(cidadeId).get();
		return cidades;	
	}
	
	public Cidade salvar(Cidade cidade){
		return cidadeRepository.save(cidade);
	}
	
	public ResponseEntity<?> atualizar(Long cidadeId, Cidade cidade){
		Optional<Cidade> cidadeAtual = cidadeRepository.findById(cidadeId);
		Optional<Estado> estado = estadoRepository.findById(cidadeAtual.get().getEstado().getId());
		
		if(estado.isPresent()){
			BeanUtils.copyProperties(cidade, cidadeAtual, "id"); //Não copiar o campo ID, para manter o ID atual.
			cidadeRepository.save(cidadeAtual.get());

			return ResponseEntity.ok(cidadeAtual.get());
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format(
				"Não existe um cadastro de cidade com código %d", 
				cidadeId
		));
	}
	
	public void remover(Long cidadeId) {
		try {
			cidadeRepository.deleteById(cidadeId);
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
