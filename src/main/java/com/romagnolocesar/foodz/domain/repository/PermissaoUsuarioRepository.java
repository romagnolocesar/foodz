package com.romagnolocesar.foodz.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romagnolocesar.foodz.domain.model.PermissaoUsuario;

@Repository
public interface PermissaoUsuarioRepository extends JpaRepository<PermissaoUsuario, Long> {

	
}