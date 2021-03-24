package com.romagnolocesar.foodz.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.TransactionScoped;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.romagnolocesar.foodz.domain.model.Cozinha;
import com.romagnolocesar.foodz.domain.model.Restaurante;
import com.romagnolocesar.foodz.domain.repository.RestauranteRepository;
import com.romagnolocesar.foodz.infrastructure.repository.RestauranteRepositoryImpl;

@RestController
public class RestauranteEndPoint {
	
	@PersistenceContext
	private EntityManager manager;
	
	
	/*
	 * http://localhost:8080/restaurantes
	 */
	@GetMapping(value="/restaurantes")
	public List<Restaurante> todos() {
		TypedQuery<Restaurante> query = manager.createQuery("from Restaurante", Restaurante.class);
		return query.getResultList();
	}
	
	/*
	 * http://localhost:8080/restaurantes/buscar?id=6
	 */
	@GetMapping(value="/restaurantes/buscar")
	public Restaurante porId(@RequestParam Long id) {
		return manager.find(Restaurante.class, id);
	}
	
	/*
	 * http://localhost:8080/restaurantes/atualizar?id=6&nome=novonome
	 */
	@Transactional
	@GetMapping(value="/restaurantes/atualizar")
	public Restaurante atualizar(
			@RequestParam Long id,
			@RequestParam String nome) {
		Restaurante restaurante = manager.find(Restaurante.class, id);
		restaurante.setNome(nome);
		System.out.println(restaurante.getNome());
		
		return(this.salvar(restaurante));
	}
	
	/*
	 * http://localhost:8080/restaurantes/add?nome=nome
	 */
	@Transactional
	@GetMapping(value="restaurantes/add")
	public Restaurante adicionar(@RequestParam String nome) {
		Restaurante restaurante = new Restaurante();
		restaurante.setNome(nome);
		return manager.merge(restaurante);
	}
	
	/*
	 * http://localhost:8080/restaurantes/remover?id=6
	 */
	@Transactional
	@GetMapping(value="/restaurantes/remover")
	public void remover(@RequestParam Long id) {
		Restaurante restaurante = manager.find(Restaurante.class, id); 
		manager.remove(restaurante);
		System.out.printf("REMOVIDO %d - %s \n", restaurante.getId(), restaurante.getNome());
	}
	
	
	
	
	public Restaurante salvar(Restaurante restaurante) {
		if(restaurante.getId() != null) {
			System.out.println("LOG: Restaurante Atualizado!");			
		}else {
			System.out.println("LOG: Restaurante Adicionado!");	
		}
		return manager.merge(restaurante);
	}
}
