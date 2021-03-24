package com.romagnolocesar.foodz.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.romagnolocesar.foodz.domain.model.PermissaoUsuario;

//@Component
@RestController
public class PermissaoUsuarioEndPoint {
	
	@PersistenceContext
	//EntityManager <- Gerencia o conceito de persistencia
	private EntityManager manager;
	
	/*
	 * http://localhost:8080/permissoesusuarios
	 */
	@GetMapping(value="/permissoesusuarios")
	public List<PermissaoUsuario> todas() {
		TypedQuery<PermissaoUsuario> query = manager.createQuery("from PermissaoUsuario", PermissaoUsuario.class);
		return query.getResultList();
	}
	
	/*
	 * http://localhost:8080/cozinhas/buscar?id=6
	 */
	@Transactional
	@GetMapping(value="permissoesusuarios/buscar")
	public PermissaoUsuario porId(@RequestParam Long id ) {
		return manager.find(PermissaoUsuario.class, id);
	}
	
	/*
	 * http://localhost:8080/PermissaoUsuario/atualizar?id=6&nome=novonome
	 */
	@Transactional
	@GetMapping(value="permissoesusuarios/atualizar")
	public PermissaoUsuario atualizar(@RequestParam Long id, @RequestParam String nome) {
		PermissaoUsuario permissaousuario = this.porId(id); 
		permissaousuario.setNome(nome);
		
		return(this.salvar(permissaousuario));
	}
	
	
	/*
	 * http://localhost:8080/permissoesusuarios/add?nome=cadastrar&descricao=Cadastrartudo
	 */
	@Transactional
	@GetMapping(value="permissoesusuarios/add")
	public PermissaoUsuario adicionar(@RequestParam String nome, @RequestParam String descricao) {
		PermissaoUsuario permissaousuario = new PermissaoUsuario();
		permissaousuario.setNome(nome);
		permissaousuario.setDescricao(descricao);
		return manager.merge(permissaousuario);
	}
	
	/*
	 * http://localhost:8080/permissoesusuarios/remover?id=6
	 */
	@Transactional
	@GetMapping(value="/permissoesusuarios/remover")
	public void remover(@RequestParam Long id ) {
		PermissaoUsuario permissaousuario = manager.find(PermissaoUsuario.class, id);		
		manager.remove(permissaousuario);
		System.out.printf("REMOVIDA %d - %s \n", permissaousuario.getId(), permissaousuario.getNome());
	}
	
	
	public PermissaoUsuario salvar(PermissaoUsuario permissaousuario) {
		if(permissaousuario.getId() != null) {
			System.out.println("LOG: Permissão de Usuário Atualizada!");			
		}else {
			System.out.println("LOG: Permissão de Usuário Adicionada!");	
		}
		return manager.merge(permissaousuario);
	}	
	
}
