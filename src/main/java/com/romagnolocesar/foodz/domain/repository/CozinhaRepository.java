package com.romagnolocesar.foodz.domain.repository;

import java.util.List;

import com.romagnolocesar.foodz.domain.model.Cozinha;

public interface CozinhaRepository {
	
	List<Cozinha> todas();
	Cozinha porId(Long id);
	Cozinha adicionar(Cozinha cozinha);
	void remover(Cozinha cozinha);
	Cozinha atualizar(Long id);
	
}