package com.romagnolocesar.foodz.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.romagnolocesar.foodz.domain.exception.EntidadeEmUsoException;
import com.romagnolocesar.foodz.domain.exception.EntidadeNaoEncontradaException;
import com.romagnolocesar.foodz.domain.model.Pedido;
import com.romagnolocesar.foodz.domain.model.StatusPedido;
import com.romagnolocesar.foodz.domain.repository.PedidoRepository;
import com.romagnolocesar.foodz.domain.service.CadastroPedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CadastroPedidoService cadastroPedidoService;
	
	@GetMapping
	public List<Pedido> listar() {
		return pedidoRepository.findAll();
	}
	
	@GetMapping("/{pedidoId}")
	public ResponseEntity<?> buscar(@PathVariable Long pedidoId) {
		Optional<Pedido> pedido = pedidoRepository.findById(pedidoId);
		
		if(pedido.isPresent()) {
			return ResponseEntity.ok(pedido.get());
		}
			
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(String.format(
						"Não existe cadastro de pedido com código %d",
						pedidoId));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> salvar(@RequestBody Pedido pedido) {
		Optional<StatusPedido> statusPedido = Optional.ofNullable(pedido.getStatus());
		
		if(statusPedido.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("O campo status é obrigatório.");
		}
		
		try{
			pedido = cadastroPedidoService.salvar(pedido);
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(pedido);
		}catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());	
		}
	}
	
	@PutMapping("/{pedidoId}")
	public ResponseEntity<?> atualizar(@PathVariable Long pedidoId, @RequestBody Pedido pedido) {
		Optional<Pedido> pedidoAtual = pedidoRepository.findById(pedidoId);
		Optional<StatusPedido> statusNovo = Optional.ofNullable(pedido.getStatus());
		
		if(statusNovo.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("O campo status é obrigatório.");
		}		
		
		if(pedidoAtual.isPresent()) {
			BeanUtils.copyProperties(pedido, pedidoAtual.get(), 
					"id", "dataCriacao");
			Pedido pedidoSalvo = cadastroPedidoService.salvar(pedidoAtual.get());
			return ResponseEntity.ok(pedidoSalvo);

		}
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(String.format(
						"Não existe cadastro de pedido com código %d",
						pedidoId));
	}
	
	@DeleteMapping("/{pedidoId}")
	public ResponseEntity<?> remover(@PathVariable Long pedidoId) {
		try {
			cadastroPedidoService.remover(pedidoId);
			return ResponseEntity.noContent().build();
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}catch(EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
	@PatchMapping("/{pedidoId}")
	public ResponseEntity<?> atualizarParcial(@PathVariable Long pedidoId, 
			@RequestBody Map<String, Object> campos){
		
		Pedido pedidoAtual = pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(
							"Não existe cadastro de pedido com código %d",
							pedidoId)));
				
		merge(campos, pedidoAtual);
		
		return atualizar(pedidoId, pedidoAtual);
	}

	private void merge(Map<String, Object> dadosOrigem, Pedido pedidoDestino) {
		ObjectMapper objectMapper = new ObjectMapper();
		Pedido pedidoOrigem = objectMapper.convertValue(dadosOrigem, Pedido.class);
		
		
		dadosOrigem.forEach((nomePropriedade, valorPropriedade) ->{
			Field field = ReflectionUtils.findField(Pedido.class, nomePropriedade);
			field.setAccessible(true);
			
			Object novoValor = ReflectionUtils.getField(field, pedidoOrigem);
			
			ReflectionUtils.setField(field, pedidoDestino, novoValor);
			
		});
	}
}
