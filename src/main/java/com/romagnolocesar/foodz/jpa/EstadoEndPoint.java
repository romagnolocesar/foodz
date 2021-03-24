package com.romagnolocesar.foodz.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.romagnolocesar.foodz.domain.model.Cozinha;
import com.romagnolocesar.foodz.domain.model.Estado;

//@Component
@RestController
public class EstadoEndPoint {
	
	@PersistenceContext
	//EntityManager <- Gerencia o conceito de persistencia
	private EntityManager manager;
	
	/*
	 * http://localhost:8080/estados
	 */
	@GetMapping(value="/estados")
	public List<Estado> todas() {
		TypedQuery<Estado> query = manager.createQuery("from Estado", Estado.class);
		return query.getResultList();
	}
	
	/*
	 * http://localhost:8080/estados/buscar?id=6
	 */
	@Transactional
	@GetMapping(value="estados/buscar")
	public Estado porId(@RequestParam Long id ) {
		return manager.find(Estado.class, id);
	}
	
	/*
	 * http://localhost:8080/estados/atualizar?id=6&nome=novonome
	 */
	@Transactional
	@GetMapping(value="estados/atualizar")
	public Estado atualizar(@RequestParam Long id, @RequestParam String nome) {
		Estado estado = this.porId(id); 
		estado.setNome(nome);
		
		return(this.salvar(estado));
	}
	
	
	/*
	 * http://localhost:8080/estados/add?nome=nome
	 */
	@Transactional
	@GetMapping(value="estados/add")
	public Estado adicionar(@RequestParam String nome) {
		Estado estado = new Estado();
		estado.setNome(nome);
		return manager.merge(estado);
	}
	
	/*
	 * http://localhost:8080/estados/remover?id=6
	 */
	@Transactional
	@GetMapping(value="/estados/remover")
	public void remover(@RequestParam Long id ) {
		Estado estado = manager.find(Estado.class, id);		
		manager.remove(estado);
		System.out.printf("REMOVIDO %d - %s \n", estado.getId(), estado.getNome());
	}
	
	
	public Estado salvar(Estado estado) {
		if(estado.getId() != null) {
			System.out.println("LOG: Estado Atualizado!");			
		}else {
			System.out.println("LOG: Estado Adicionado!");	
		}
		return manager.merge(estado);
	}	
	
}
