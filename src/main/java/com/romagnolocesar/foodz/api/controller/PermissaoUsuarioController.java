package com.romagnolocesar.foodz.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.romagnolocesar.foodz.domain.exception.EntidadeEmUsoException;
import com.romagnolocesar.foodz.domain.exception.EntidadeNaoEncontradaException;
import com.romagnolocesar.foodz.domain.model.PermissaoUsuario;
import com.romagnolocesar.foodz.domain.repository.PermissaoUsuarioRepository;
import com.romagnolocesar.foodz.domain.service.CadastroPermissaoUsuarioService;

@RestController
@RequestMapping("/permissoes")
public class PermissaoUsuarioController {
	
	@Autowired
	PermissaoUsuarioRepository permissaoRepository;
	
	@Autowired
	private CadastroPermissaoUsuarioService cadastroPermissaoUsuarioService;
	
	@GetMapping
	public List<PermissaoUsuario> listar(){
		return permissaoRepository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<PermissaoUsuario> buscar(@PathVariable Long id ) {
		Optional<PermissaoUsuario> permissao = permissaoRepository.findById(id);
		
		if(permissao != null) {
			return ResponseEntity.ok(permissao.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@Transactional
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PermissaoUsuario adicionar(@RequestBody PermissaoUsuario permissao) {
		return permissaoRepository.save(permissao);
	}
	
	@PutMapping("/{permissaoUsuarioId}")
	public ResponseEntity<?> atualizar(@PathVariable Long permissaoUsuarioId, @RequestBody PermissaoUsuario permissaoUsuario){
		return cadastroPermissaoUsuarioService.atualizar(permissaoUsuarioId, permissaoUsuario);
	}
	
	@DeleteMapping("/{permissaoUsuarioId}")
	public ResponseEntity<?> remover(@PathVariable Long permissaoUsuarioId) {
		try {
			cadastroPermissaoUsuarioService.remover(permissaoUsuarioId);
			return ResponseEntity.noContent().build();
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}catch(EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
}
