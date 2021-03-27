package com.romagnolocesar.foodz.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.romagnolocesar.foodz.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {

	List<Restaurante> find(String nome, 
			BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);
	
	 List<Restaurante> findComFreteGratis(String Nome);

}