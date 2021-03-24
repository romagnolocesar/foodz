package com.romagnolocesar.foodz.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.romagnolocesar.foodz.domain.model.Cozinha;

//@Component
@RestController
public class CadastroCozinha {
	
	//EntityManager <- Gerencia o conceito de persistencia
	@PersistenceContext
	private EntityManager manager;
	
	/*
	 * http://localhost:8080/cozinhas
	 */
	@GetMapping(value="/cozinhas")
	public List<Cozinha> listar() {
		TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
		return query.getResultList();
	}
	
	/*
	 * http://localhost:8080/cozinhas/buscar?id=6
	 */
	@Transactional
	@GetMapping(value="cozinhas/buscar")
	public Cozinha buscar(@RequestParam Long id ) {
		return manager.find(Cozinha.class, id);
	}
	
	/*
	 * http://localhost:8080/cozinhas/atualizar?id=6&nome=novonome
	 */
	@Transactional
	@GetMapping(value="cozinhas/atualizar")
	public Cozinha atualizar(@RequestParam Long id, @RequestParam String nome) {
		Cozinha cozinha = this.buscar(id); 
		cozinha.setNome(nome);
		
		return(this.salvar(cozinha));
	}
	
	
	/*
	 * http://localhost:8080/cozinhas/add
	 */
	@Transactional
	@GetMapping(value="cozinhas/add")
	public String salvarCall() {
		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Chinesa");
		
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Pizzas");
		
		cozinha1 = this.salvar(cozinha1);
		cozinha2 = this.salvar(cozinha2);
		
		System.out.printf("%d - %s \n", cozinha1.getId(), cozinha1.getNome());
		System.out.printf("%d - %s \n", cozinha2.getId(), cozinha2.getNome());
		
		return "Cozinha Adicionada!";
	}
	
	/*
	 * http://localhost:8080/cozinhas/remover?id=6
	 */
	@Transactional
	@GetMapping(value="/cozinhas/remover")
	public void removerCall(@RequestParam Long id ) {
		Cozinha cozinha = manager.find(Cozinha.class, id); 
		this.remover(cozinha);
		System.out.println("LOG: Cozinha Removida!");
	}
	
	
	public Cozinha salvar(Cozinha cozinha) {
		if(cozinha.getId() != null) {
			System.out.println("LOG: Cozinha Atualizada!");			
		}else {
			System.out.println("LOG: Cozinha Adicionada!");	
		}
		return manager.merge(cozinha);
	}
	
	public void remover(Cozinha cozinha) {
		manager.remove(cozinha);
		System.out.printf("REMOVIDA %d - %s \n", cozinha.getId(), cozinha.getNome());
	}
	
	
}
