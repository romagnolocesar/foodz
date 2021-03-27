package com.romagnolocesar.foodz.api.controller;

import static com.romagnolocesar.foodz.infrastructure.repository.spec.RestauranteSpecs.comFreteGratis;
import static com.romagnolocesar.foodz.infrastructure.repository.spec.RestauranteSpecs.comNomeSemelhante;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.romagnolocesar.foodz.domain.model.Cozinha;
import com.romagnolocesar.foodz.domain.model.Restaurante;
import com.romagnolocesar.foodz.domain.repository.CozinhaRepository;
import com.romagnolocesar.foodz.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/teste")
public class TestController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@GetMapping("/cozinhas/por-nome")
	public Optional<Cozinha> cozinhasPorNome(@RequestParam String nome){
		return cozinhaRepository.findByNome(nome);
	}
	
	@GetMapping("/cozinhas/por-nome-contendo")
	public List<Cozinha> cozinhasPorNomeCotendo(String nome){
		return cozinhaRepository.findAllByNomeContaining(nome);
	}
	
	@GetMapping("/cozinhas/existe-por-nome")
	public boolean existsPorNome(String nome){
		return cozinhaRepository.existsByNome(nome);
	}

	
	
	
	@GetMapping("/restaurantes/por-taxa-frete")
	public List<Restaurante> restaurantePorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal){
		return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
	}
	
	@GetMapping("/restaurantes/por-nome")
	public List<Restaurante> restaurantePorTaxaFrete(
			String nome, Long cozinha){
		return restauranteRepository.consultarPorNome(nome, cozinha);
	}
	
	@GetMapping("/restaurantes/primeiro-por-nome-contendo")
	public Optional<Restaurante> primeiropornome(String nome){
		return restauranteRepository.findFirstByNomeContaining(nome);
	}
	
	@GetMapping("/restaurantes/por-nome-e-frete")
	public List<Restaurante> restaurantesPorNomeFrete(String nome,
			BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
		return restauranteRepository.find(nome, taxaFreteInicial, taxaFreteFinal);
	}
	
	
	
	@GetMapping("/restaurantes/com-frete-gratis")
	public List<Restaurante> restaurantesComFreteGratis(String nome){
		return restauranteRepository.findComFreteGratis(nome);
	}
	
	
}
