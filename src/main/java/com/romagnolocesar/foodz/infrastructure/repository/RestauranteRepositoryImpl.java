package com.romagnolocesar.foodz.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.romagnolocesar.foodz.domain.model.Restaurante;
import com.romagnolocesar.foodz.domain.repository.RestauranteRepository;

public class RestauranteRepositoryImpl implements RestauranteRepository{


	@Override
	public List<Restaurante> todos() {
		// TODO Auto-generated method stub
		return null;	
	}

	@Override
	public Restaurante porId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurante adicionar(Restaurante restaurante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Restaurante restaurante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Restaurante atualizar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
