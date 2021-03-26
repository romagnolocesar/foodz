package com.romagnolocesar.foodz.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.romagnolocesar.foodz.domain.model.Cozinha;
import com.romagnolocesar.foodz.domain.repository.CozinhaRepository;

@RestController
@RequestMapping("/teste")
public class TestController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
//	@GetMapping("/cozinhas/por-nome")
//	public List<Cozinha> cozinhasPorNome(@RequestParam String nome){
//		return cozinhaRepository.consultarPorNome(nome);
//	}
	
}
