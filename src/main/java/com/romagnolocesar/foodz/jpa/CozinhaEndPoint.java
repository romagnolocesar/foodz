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

//@Component
@RestController
public class CozinhaEndPoint {
	
	@PersistenceContext
	//EntityManager <- Gerencia o conceito de persistencia
	private EntityManager manager;
	
	/*
	 * http://localhost:8080/cozinhas
	 */
	@GetMapping(value="/cozinhas")
	public List<Cozinha> todas() {
		TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
		return query.getResultList();
	}
	
	/*
	 * http://localhost:8080/cozinhas/buscar?id=6
	 */
	@Transactional
	@GetMapping(value="cozinhas/buscar")
	public Cozinha porId(@RequestParam Long id ) {
		return manager.find(Cozinha.class, id);
	}
	
	/*
	 * http://localhost:8080/cozinhas/atualizar?id=6&nome=novonome
	 */
	@Transactional
	@GetMapping(value="cozinhas/atualizar")
	public Cozinha atualizar(@RequestParam Long id, @RequestParam String nome) {
		Cozinha cozinha = this.porId(id); 
		cozinha.setNome(nome);
		
		return(this.salvar(cozinha));
	}
	
	
	/*
	 * http://localhost:8080/cozinhas/add?nome=nome
	 */
	@Transactional
	@GetMapping(value="cozinhas/add")
	public Cozinha adicionar(@RequestParam String nome) {
		Cozinha cozinha = new Cozinha();
		cozinha.setNome(nome);
		return manager.merge(cozinha);
	}
	
	/*
	 * http://localhost:8080/cozinhas/remover?id=6
	 */
	@Transactional
	@GetMapping(value="/cozinhas/remover")
	public void remover(@RequestParam Long id ) {
		Cozinha cozinha = manager.find(Cozinha.class, id);		
		manager.remove(cozinha);
		System.out.printf("REMOVIDA %d - %s \n", cozinha.getId(), cozinha.getNome());
	}
	
	
	public Cozinha salvar(Cozinha cozinha) {
		if(cozinha.getId() != null) {
			System.out.println("LOG: Cozinha Atualizada!");			
		}else {
			System.out.println("LOG: Cozinha Adicionada!");	
		}
		return manager.merge(cozinha);
	}	
	
}
