//package com.romagnolocesar.foodz.jpa;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.romagnolocesar.foodz.domain.model.FormaPagamento;
//
//@RestController
//public class FormaPagamentoEndPoint {
//	
//	@PersistenceContext
//	private EntityManager manager;
//	
//	/*
//	 * http://localhost:8080/formaspagamentos
//	 */
//	@GetMapping(value="/formaspagamentos2")
//	public List<FormaPagamento> todas() {
//		TypedQuery<FormaPagamento> query = manager.createQuery("from FormaPagamento", FormaPagamento.class);
//		return query.getResultList();
//	}
//	
//	/*
//	 * http://localhost:8080/formaspagamentos/buscar?id=6
//	 */
//	@GetMapping(value="formaspagamentos/buscar")
//	public FormaPagamento porId(@RequestParam Long id) {
//		return manager.find(FormaPagamento.class, id);
//	}
//	
//	/*
//	 * http://localhost:8080/formaspagamentos/atualizar?id=6&descricao=novadescricao
//	 */
//	@Transactional
//	@GetMapping(value="formaspagamentos/atualizar")
//	public FormaPagamento atualizar(
//			@RequestParam Long id,
//			@RequestParam String descricao) {
//		FormaPagamento formapagamento = manager.find(FormaPagamento.class, id);
//		formapagamento.setDescricao(descricao);
//		System.out.println(formapagamento.getDescricao());
//		
//		return(this.salvar(formapagamento));
//	}
//	
//	
//	/*
//	 * http://localhost:8080/formaspagamentos/add?descricao=nome
//	 */
//	@Transactional
//	@GetMapping(value="formaspagamentos/add")
//	public FormaPagamento adicionar(@RequestParam String descricao) {
//		FormaPagamento formapagamento = new FormaPagamento();
//		formapagamento.setDescricao(descricao);
//		return manager.merge(formapagamento);
//	}
//	
//	/*
//	 * http://localhost:8080/formaspagamentos/remover?id=6
//	 */
//	@Transactional
//	@GetMapping(value="/formaspagamentos/remover")
//	public void remover(@RequestParam Long id) {
//		FormaPagamento formapagamento = manager.find(FormaPagamento.class, id); 
//		manager.remove(formapagamento);
//		System.out.printf("REMOVIDO %d - %s \n", formapagamento.getId(), formapagamento.getDescricao());
//	}
//	
//	
//	
//	public FormaPagamento salvar(FormaPagamento formapagamento) {
//		if(formapagamento.getId() != null) {
//			System.out.println("LOG: Forma de Pagamento Atualizada!");			
//		}else {
//			System.out.println("LOG: Forma de Pagamento Adicionada!");	
//		}
//		return manager.merge(formapagamento);
//	}
//}
