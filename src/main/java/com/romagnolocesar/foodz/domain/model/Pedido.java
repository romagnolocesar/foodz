package com.romagnolocesar.foodz.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.print.attribute.standard.DateTimeAtCompleted;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pedido {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private BigDecimal subTotal;
	
	@Column(name = "taxa_frete", nullable = false)
	private BigDecimal taxaFrete;
	
	@Column(name = "valor_total", nullable = false)
	private BigDecimal valorTotal;
	
	@Embedded
	private Endereco endereco_entrega;
	
	@OneToOne
	@JoinColumn(name = "restaurante_id", nullable = false)
	private Restaurante restaurante;
	
	@OneToOne
	@JoinColumn(name="forma_pagamento_id", nullable = false)
	private FormaPagamento forma_pagamento;
	
	@CreationTimestamp
	@Column(name = "data_criacao", nullable = false)
	private LocalDateTime dataCriacao;
	
	@Column(name="data_confirmacao")
	private LocalDateTime dataConfirmacao;
	
	@Column(name="data_cancelamento")
	private LocalDateTime dataCancelamento;
	
	@Column(name="data_entrega")
	private LocalDateTime dataEntrega;
	
	@OneToOne
	@JoinColumn(name="cliente_id", nullable = false)
	private Usuario cliente;
	
	@Column(name="status", nullable = false)
	private StatusPedido status;
	
}
