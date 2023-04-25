package com.matheus.fastfoodie.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.fastfoodie.domain.model.FormaPagamento;
import com.matheus.fastfoodie.domain.repository.FormaPagamentoRepository;

@Repository
public class FormaPagamentoImpl implements FormaPagamentoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<FormaPagamento> listar() {
        return entityManager.createQuery("from FormaPagamento", FormaPagamento.class)
                .getResultList();
    }

    public FormaPagamento buscar(Long id) {
        return entityManager.find(FormaPagamento.class, id);
    }

    @Transactional
    public FormaPagamento salvar(FormaPagamento formaPagamento) {
        return entityManager.merge(formaPagamento);
    }

    @Transactional
    public void remover(FormaPagamento formaPagamento) {
    	formaPagamento = buscar(formaPagamento.getId());
        entityManager.remove(formaPagamento);
    }

}

