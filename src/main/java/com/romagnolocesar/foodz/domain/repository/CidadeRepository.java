package com.romagnolocesar.foodz.domain.repository;

import java.util.List;

import com.romagnolocesar.foodz.domain.model.Cidade;

public interface CidadeRepository {
	
	List<Cidade> todos();
	Cidade porId(Long id);
	Cidade adicionar(Cidade estado);
	void remover(Cidade estado);
	Cidade atualizar(Long id);
	
}