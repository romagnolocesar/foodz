package com.romagnolocesar.foodz.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.romagnolocesar.foodz.domain.model.PermissaoUsuario;
import com.romagnolocesar.foodz.domain.repository.PermissaoUsuarioRepository;

@Component
public class PermissaoUsuarioRepositoryImpl implements PermissaoUsuarioRepository {
	
	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<PermissaoUsuario> listar() {
		return manager.createQuery("from PermissaoUsuario", PermissaoUsuario.class).getResultList();
	}

	@Override
	public PermissaoUsuario buscar(Long id) {
		return manager.find(PermissaoUsuario.class, id);
		
		
	}

	@Override
	public PermissaoUsuario salvar(PermissaoUsuario permissaousuario) {
		System.out.println("Nome::::::: "+ permissaousuario.getNome()+ "\n");
		System.out.println("Descrição::::::: "+ permissaousuario.getDescricao()+ "\n");
		return manager.merge(permissaousuario);
	}

	@Override
	public void remover(PermissaoUsuario permissaousuario) {
		// TODO Auto-generated method stub
		
	}
		
}
