package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Mensagem;
import jakarta.ejb.EJB;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless(name = "mensagemService")
@Remote
public class MensagemService {

    @EJB
    private MensagemDAO mensagemDao;

    public List<Mensagem> listar() {
        return mensagemDao.listar();
    }

    public void inserir(long id, String conteudo) {
        Mensagem novaMsg = new Mensagem(id, conteudo);
        novaMsg.setConteudo(novaMsg.getConteudo() + " - u" + novaMsg.getId());
        mensagemDao.inserir(novaMsg);
    }
}
