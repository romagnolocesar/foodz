package com.romagnolocesar.foodz.domain.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.romagnolocesar.foodz.domain.exception.EntidadeEmUsoException;
import com.romagnolocesar.foodz.domain.exception.EntidadeNaoEncontradaException;
import com.romagnolocesar.foodz.domain.model.PermissaoUsuario;
import com.romagnolocesar.foodz.domain.repository.EstadoRepository;
import com.romagnolocesar.foodz.domain.repository.PermissaoUsuarioRepository;

@Service
public class CadastroPermissaoUsuarioService {
	
	@Autowired
	PermissaoUsuarioRepository permissaoUsuarioRespository;
	
	public PermissaoUsuario salvar(PermissaoUsuario estado) {
		return permissaoUsuarioRespository.save(estado);
	}
	
	public ResponseEntity<?> atualizar(Long permissaoUsuarioId, PermissaoUsuario estado){
		Optional<PermissaoUsuario> permissaoUsuarioAtual = permissaoUsuarioRespository.findById(permissaoUsuarioId);
		
		if(permissaoUsuarioAtual.isPresent()) {
			permissaoUsuarioAtual = Optional.ofNullable(permissaoUsuarioAtual.get());
			BeanUtils.copyProperties(estado, permissaoUsuarioAtual.get(), "id");
			permissaoUsuarioRespository.save(permissaoUsuarioAtual.get());

			return ResponseEntity.ok(permissaoUsuarioAtual);
		}
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(String.format(
						"Não existe cadastro de Permissão de Usuário com código %d",
						permissaoUsuarioId));
	}

	public void remover(Long permissaoUsuarioId) {
		try {
				permissaoUsuarioRespository.deleteById(permissaoUsuarioId);
		} catch (EmptyResultDataAccessException e) {
			throw new 
			EntidadeNaoEncontradaException(
				String.format(
						"Não existe um cadastro de Permissão de Usuário com código %d", 
						permissaoUsuarioId
				)
			);
		} catch (DataIntegrityViolationException e) {
			throw new 
			EntidadeEmUsoException(
				String.format(
					"Permissão de Usuário de código %d não pode ser removida, pois está em uso.", 
					permissaoUsuarioId
				)
			);
		}
	
	}
	
	
}
