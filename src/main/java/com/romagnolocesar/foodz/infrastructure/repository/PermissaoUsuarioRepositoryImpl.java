package com.romagnolocesar.foodz.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.romagnolocesar.foodz.domain.model.Cozinha;
import com.romagnolocesar.foodz.domain.model.FormaPagamento;
import com.romagnolocesar.foodz.domain.model.PermissaoUsuario;
import com.romagnolocesar.foodz.domain.repository.CozinhaRepository;
import com.romagnolocesar.foodz.domain.repository.PermissaoUsuarioRepository;

public class PermissaoUsuarioRepositoryImpl implements PermissaoUsuarioRepository {
	
	@Override
	public List<PermissaoUsuario> todas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PermissaoUsuario porId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PermissaoUsuario adicionar(PermissaoUsuario permissaousuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(PermissaoUsuario permissaousuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PermissaoUsuario atualizar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
		
		
		
}
