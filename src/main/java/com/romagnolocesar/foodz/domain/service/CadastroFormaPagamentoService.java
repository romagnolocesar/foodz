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
import com.romagnolocesar.foodz.domain.model.FormaPagamento;
import com.romagnolocesar.foodz.domain.repository.FormaPagamentoRepository;

@Service
public class CadastroFormaPagamentoService {
	
	@Autowired
	FormaPagamentoRepository formaPagamentoRespository;
	
	public FormaPagamento salvar(FormaPagamento formaPagamento) {
		return formaPagamentoRespository.save(formaPagamento);
	}
	
	public ResponseEntity<?> atualizar(Long formaPagamentoId, FormaPagamento formaPagamento){
		Optional<FormaPagamento> formaPagamentoAtual = formaPagamentoRespository.findById(formaPagamentoId);
		
		if(formaPagamentoAtual.isPresent()) {
			formaPagamentoAtual = Optional.ofNullable(formaPagamentoAtual.get());
			BeanUtils.copyProperties(formaPagamento, formaPagamentoAtual.get(), "id"); //Não copiar o campo ID, para manter o ID atual.
			formaPagamentoRespository.save(formaPagamentoAtual.get());

			return ResponseEntity.ok(formaPagamentoAtual);
		}
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(String.format(
						"Não existe cadastro de Forma de Pagamento de pagamento com código %d",
						formaPagamentoId));
	}

	public void remover(Long estadoId) {
		try {
				formaPagamentoRespository.deleteById(estadoId);
		} catch (EmptyResultDataAccessException e) {
			throw new 
			EntidadeNaoEncontradaException(
				String.format(
						"Não existe um cadastro de Forma de Pagamento com código %d", 
						estadoId
				)
			);
		} catch (DataIntegrityViolationException e) {
			throw new 
			EntidadeEmUsoException(
				String.format(
					"Forma de Pagamento de código %d não pode ser removida, pois está em uso.", 
					estadoId
				)
			);
		}
	
	}
	
	
}
