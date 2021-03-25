package com.romagnolocesar.foodz.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romagnolocesar.foodz.domain.model.PermissaoUsuario;
import com.romagnolocesar.foodz.domain.repository.PermissaoUsuarioRepository;

@RestController
@RequestMapping("/permissoes")
public class PermissaoUsuarioController {
	
	@Autowired
	PermissaoUsuarioRepository permissaoRepository;
	
	@GetMapping
	public List<PermissaoUsuario> listar(){
		return permissaoRepository.listar();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<PermissaoUsuario> buscar(@PathVariable Long id ) {
		PermissaoUsuario permissao = permissaoRepository.buscar(id);
		
		if(permissao != null) {
			return ResponseEntity.ok(permissao);
		}
		
		return ResponseEntity.notFound().build();
	}
}
