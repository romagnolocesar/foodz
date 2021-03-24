package com.romagnolocesar.foodz.domain.repository;

import java.util.List;

import com.romagnolocesar.foodz.domain.model.Cozinha;
import com.romagnolocesar.foodz.domain.model.Estado;

public interface EstadoRepository {
	
	List<Estado> todos();
	Estado porId(Long id);
	Estado adicionar(Estado estado);
	void remover(Estado estado);
	Estado atualizar(Long id);
	
}