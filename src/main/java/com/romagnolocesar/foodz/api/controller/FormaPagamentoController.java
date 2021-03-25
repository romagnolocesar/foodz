package com.romagnolocesar.foodz.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.romagnolocesar.foodz.domain.model.Cozinha;
import com.romagnolocesar.foodz.domain.model.Estado;
import com.romagnolocesar.foodz.domain.model.FormaPagamento;
import com.romagnolocesar.foodz.domain.repository.FormaPagamentoRepository;

@RestController
@RequestMapping("/formaspagamentos")
public class FormaPagamentoController {
	
	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	@GetMapping
	public List<FormaPagamento> listar(){
		return formaPagamentoRepository.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FormaPagamento> buscar(@PathVariable Long id) {
		FormaPagamento formapagamento = formaPagamentoRepository.buscar(id);
		
		if(formapagamento != null) {
			return ResponseEntity.ok(formapagamento);
		}
		
		return ResponseEntity.notFound().build();
	}


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
//	NAO FUNCIONANDO
	public FormaPagamento adicionar(@RequestBody FormaPagamento formaPagamento) {
		return formaPagamentoRepository.salvar(formaPagamento);
	}
}
