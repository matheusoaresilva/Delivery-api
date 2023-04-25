package com.matheus.fastfoodie.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.fastfoodie.domain.model.Cidade;
import com.matheus.fastfoodie.domain.repository.CidadeRepository;

@Repository
public class CidadeImpl implements CidadeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cidade> listar() {
        return entityManager.createQuery("from Cidade", Cidade.class)
                .getResultList();
    }

    public Cidade buscar(Long id) {
        return entityManager.find(Cidade.class, id);
    }

    @Transactional
    public Cidade salvar(Cidade cidade) {
        return entityManager.merge(cidade);
    }

    @Transactional
    public void remover(Cidade cidade) {
    	cidade = buscar(cidade.getId());
        entityManager.remove(cidade);
    }

}

