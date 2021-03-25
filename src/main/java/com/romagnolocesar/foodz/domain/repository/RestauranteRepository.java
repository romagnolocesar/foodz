package com.romagnolocesar.foodz.domain.repository;

import java.util.List;

import com.romagnolocesar.foodz.domain.model.Restaurante;

public interface RestauranteRepository {
	List<Restaurante> listar();
	Restaurante buscar(Long id);
	Restaurante adicionar(Restaurante restaurante);
	void remover(Restaurante restaurante);
	Restaurante salvar(Restaurante restaurante);
}
