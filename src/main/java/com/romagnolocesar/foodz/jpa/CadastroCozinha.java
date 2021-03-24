package com.romagnolocesar.foodz.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romagnolocesar.foodz.domain.model.Cozinha;

//@Component
@RestController
public class CadastroCozinha {
	
	//EntityManager <- Gerencia o conceito de persistencia
	@PersistenceContext
	private EntityManager manager;
	
	@GetMapping(value="/cozinhas")
	public List<Cozinha> listar() {
		TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
		return query.getResultList();
	}
	
	@Transactional
	@GetMapping(value="cozinhas/add")
	public String adicionarCall() {
		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Chinesa");
		
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Pizzas");
		
		cozinha1 = this.adicionar(cozinha1);
		cozinha2 = this.adicionar(cozinha2);
		
		System.out.printf("%d - %s \n", cozinha1.getId(), cozinha1.getNome());
		System.out.printf("%d - %s \n", cozinha2.getId(), cozinha2.getNome());
		
		return "Cozinha Adicionada!";
	}
	
	public Cozinha adicionar(Cozinha cozinha) {
		return manager.merge(cozinha);
		
//		System.out.println("LOG: Cozinha Adicionada!");
//		return "Cozinha Adicionada!";
	}
	
	
}
