package com.romagnolocesar.foodz.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ItemPedido {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="quantidade", nullable = false)
	private int quantidade;
	
	@Column(name="preco_unitario", nullable = false)
	private BigDecimal precoUnitario;
	
	@Column(name="preco_total", nullable = false)
	private BigDecimal precoTotal;
	
	@Column(name="observacao")
	private	String observacao;
	
	@OneToOne
	@JoinColumn(name="produto", nullable = false)
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="pedido_id")
	private Pedido pedido;

}
