package com.romagnolocesar.foodz.domain.repository;

import java.util.List;

import com.romagnolocesar.foodz.domain.model.Cozinha;
import com.romagnolocesar.foodz.domain.model.PermissaoUsuario;

public interface PermissaoUsuarioRepository {
	
	List<PermissaoUsuario> todas();
	PermissaoUsuario porId(Long id);
	PermissaoUsuario adicionar(PermissaoUsuario cozinha);
	void remover(PermissaoUsuario cozinha);
	PermissaoUsuario atualizar(Long id);
	
}