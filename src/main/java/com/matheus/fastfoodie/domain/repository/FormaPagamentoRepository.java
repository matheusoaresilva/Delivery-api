package com.matheus.fastfoodie.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.matheus.fastfoodie.domain.model.FormaPagamento;
@Repository
public interface FormaPagamentoRepository {
	
	List<FormaPagamento> listar();
	FormaPagamento buscar(Long id);
	FormaPagamento salvar(FormaPagamento formaPagamento);
	void remover(FormaPagamento formaPagamento);

}
