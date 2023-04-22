package com.matheus.fastfoodie.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.fastfoodie.domain.model.Permissao;
import com.matheus.fastfoodie.domain.repository.PermissaoRepository;

@Repository
public class PermissaoImpl implements PermissaoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Permissao> listar() {
        return entityManager.createQuery("from Permissao", Permissao.class)
                .getResultList();
    }

    public Permissao buscar(Long id) {
        return entityManager.find(Permissao.class, id);
    }

    @Transactional
    public Permissao salvar(Permissao permissao) {
        return entityManager.merge(permissao);
    }

    @Transactional
    public void remover(Permissao permissao) {
    	permissao = buscar(permissao.getId());
        entityManager.remove(permissao);
    }

}

