package com.romagnolocesar.foodz.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romagnolocesar.foodz.domain.exception.EntidadeNaoEncontradaException;
import com.romagnolocesar.foodz.domain.model.Cidade;
import com.romagnolocesar.foodz.domain.model.Cozinha;
import com.romagnolocesar.foodz.domain.model.Estado;
import com.romagnolocesar.foodz.domain.model.Restaurante;
import com.romagnolocesar.foodz.domain.repository.CidadeRepository;
import com.romagnolocesar.foodz.domain.repository.EstadoRepository;
import com.romagnolocesar.foodz.domain.repository.RestauranteRepository;

@Service
public class CadastroCidadeService {
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	public List<Cidade> listar(){
		return cidadeRepository.listar();
	}
	
	public Cidade buscar(Long cidadeId) {
		Cidade cidades = cidadeRepository.buscar(cidadeId);
		return cidades;	
	}
	
	public Cidade salvar(Cidade cidade){
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.buscar(estadoId);
		
		if(estado == null) {
			throw new EntidadeNaoEncontradaException(
					String.format(
							"Não existe cadastro de cozinha com código %d",
							estadoId
					)
				);
		}
	
		cidade.setEstado(estado);
		
		return cidadeRepository.salvar(cidade);
	}
}
