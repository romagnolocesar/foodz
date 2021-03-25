//package com.romagnolocesar.foodz.jpa;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.romagnolocesar.foodz.domain.model.Cidade;
//import com.romagnolocesar.foodz.domain.model.Estado;
//
////@Component
//@RestController
//public class CidadeEndPoint {
//	
//	@PersistenceContext
//	//EntityManager <- Gerencia o conceito de persistencia
//	private EntityManager manager;
//	
//	/*
//	 * http://localhost:8080/cidades
//	 */
//	@GetMapping(value="/cidades2")
//	public List<Cidade> todas() {
//		TypedQuery<Cidade> query = manager.createQuery("from Cidade", Cidade.class);
//		return query.getResultList();
//	}
//	
//	/*
//	 * http://localhost:8080/cidades/buscar?id=6
//	 */
//	@Transactional
//	@GetMapping(value="cidades/buscar")
//	public Cidade porId(@RequestParam Long id ) {
//		return manager.find(Cidade.class, id);
//	}
//	
//	/*
//	 * http://localhost:8080/cidade/atualizar?id=6&nome=novonome
//	 */
//	@Transactional
//	@GetMapping(value="cidades2/atualizar")
//	public Cidade atualizar(@RequestParam Long id, @RequestParam String nome) {
//		Cidade cidade = this.porId(id); 
//		cidade.setNome(nome);
//		
//		return(this.salvar(cidade));
//	}
//	
//	
//	/*
//	 * http://localhost:8080/cidades/add?nome=nome
//	 */
//	@Transactional
//	@GetMapping(value="cidades2/add")
//	public Cidade adicionar(@RequestParam String nome) {
//		Cidade cidade = new Cidade();
//		cidade.setNome(nome);
//		Estado estado = manager.find(Estado.class, 1L);
//		cidade.setEstado(estado);
//		return manager.merge(cidade);
//	}
//	
//	/*
//	 * http://localhost:8080/cidades/remover?id=6
//	 */
//	@Transactional
//	@GetMapping(value="/cidades2/remover")
//	public void remover(@RequestParam Long id ) {
//		Cidade cidade = manager.find(Cidade.class, id);		
//		manager.remove(cidade);
//		System.out.printf("REMOVIDO %d - %s \n", cidade.getId(), cidade.getNome());
//	}
//	
//	
//	public Cidade salvar(Cidade cidade) {
//		if(cidade.getId() != null) {
//			System.out.println("LOG: Estado Atualizado!");			
//		}else {
//			System.out.println("LOG: Estado Adicionado!");	
//		}
//		return manager.merge(cidade);
//	}	
//	
//}
