package com.romagnolocesar.foodz.domain.repository;

import java.util.List;

import com.romagnolocesar.foodz.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {
	List<FormaPagamento> todas();
	FormaPagamento porId(Long id);
	FormaPagamento adicionar(FormaPagamento formapagamento);
	void remover(FormaPagamento formapagamento);
	FormaPagamento atualizar(Long id);
}
