package com.romagnolocesar.foodz.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.romagnolocesar.foodz.domain.exception.EntidadeEmUsoException;
import com.romagnolocesar.foodz.domain.exception.EntidadeNaoEncontradaException;
import com.romagnolocesar.foodz.domain.model.FormaPagamento;
import com.romagnolocesar.foodz.domain.model.FormaPagamento;
import com.romagnolocesar.foodz.domain.repository.FormaPagamentoRepository;
import com.romagnolocesar.foodz.domain.service.CadastroEstadoService;
import com.romagnolocesar.foodz.domain.service.CadastroFormaPagamentoService;

@RestController
@RequestMapping("/formaspagamentos")
public class FormaPagamentoController {
	
	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	@Autowired
	private CadastroFormaPagamentoService cadastroFormaPagamentoService;
	
	@GetMapping
	public List<FormaPagamento> listar(){
		return formaPagamentoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FormaPagamento> buscar(@PathVariable Long id) {
		Optional<FormaPagamento> formapagamento = formaPagamentoRepository.findById(id);
		
		if(formapagamento != null) {
			return ResponseEntity.ok(formapagamento.get());
		}
		
		return ResponseEntity.notFound().build();
	}


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public FormaPagamento adicionar(@RequestBody FormaPagamento formaPagamento) {
		return formaPagamentoRepository.save(formaPagamento);
	}
	
	@PutMapping("/{formaPagamentoId}")
	public ResponseEntity<?> atualizar(@PathVariable Long formaPagamentoId, @RequestBody FormaPagamento formaPagamento){
		return cadastroFormaPagamentoService.atualizar(formaPagamentoId, formaPagamento);
	}
	
	@DeleteMapping("/{formaPagamentoId}")
	public ResponseEntity<?> remover(@PathVariable Long formaPagamentoId) {
		try {
			cadastroFormaPagamentoService.remover(formaPagamentoId);
			return ResponseEntity.noContent().build();
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}catch(EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
}
