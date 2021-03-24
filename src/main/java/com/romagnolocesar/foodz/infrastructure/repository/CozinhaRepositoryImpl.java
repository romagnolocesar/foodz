package com.romagnolocesar.foodz.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.romagnolocesar.foodz.domain.model.Cozinha;
import com.romagnolocesar.foodz.domain.repository.CozinhaRepository;

public class CozinhaRepositoryImpl implements CozinhaRepository {
	//EntityManager <- Gerencia o conceito de persistencia
		@PersistenceContext
		private EntityManager manager;
		
		@Override
		public List<Cozinha> todas() {
			System.out.println("ENTREI NO REPOSITORIO");
			TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
			return query.getResultList();
		}
		

		@Override
		public Cozinha porId(@RequestParam Long id ) {
			return manager.find(Cozinha.class, id);
		}
		
		@Override
		public Cozinha adicionar(Cozinha cozinha) {
			if(cozinha.getId() != null) {
				System.out.println("LOG: Cozinha Atualizada!");			
			}else {
				System.out.println("LOG: Cozinha Adicionada!");	
			}
			return manager.merge(cozinha);
		}
		
		@Override
		public void remover(Cozinha cozinha) {
			manager.remove(cozinha);
			System.out.printf("REMOVIDA %d - %s \n", cozinha.getId(), cozinha.getNome());
		}
		
		
		@Override
		public Cozinha atualizar(Long id) {
			Cozinha cozinha = this.porId(id); 
			
			return(this.adicionar(cozinha));
		}
		
		
		
}
