package com.romagnolocesar.foodz.domain.repository;

import java.util.List;

import com.romagnolocesar.foodz.domain.model.PermissaoUsuario;

public interface PermissaoUsuarioRepository {
	
	List<PermissaoUsuario> listar();
	PermissaoUsuario buscar(Long id);
	PermissaoUsuario salvar(PermissaoUsuario cozinha);
	void remover(PermissaoUsuario cozinha);
	
}