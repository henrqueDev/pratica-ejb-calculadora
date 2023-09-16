package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Mensagem;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MensagemDAO {

    @PersistenceContext(unitName="bd2")
    private EntityManager em;

    public void inserir(Mensagem message){
        em.persist(message);
    }

    public List<Mensagem> listar() {
        return em.createQuery("SELECT m FROM tb_mensagem m").getResultList();
    }

    public Mensagem pesquisarByID(int id) {
        return em.find(Mensagem.class, id);
    }
}
