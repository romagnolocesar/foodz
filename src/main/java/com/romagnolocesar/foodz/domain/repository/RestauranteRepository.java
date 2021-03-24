package com.romagnolocesar.foodz.domain.repository;

import java.util.List;

import com.romagnolocesar.foodz.domain.model.Restaurante;

public interface RestauranteRepository {
	List<Restaurante> todos();
	Restaurante porId(Long id);
	Restaurante adicionar(Restaurante restaurante);
	void remover(Restaurante restaurante);
	Restaurante atualizar(Long id);
}
