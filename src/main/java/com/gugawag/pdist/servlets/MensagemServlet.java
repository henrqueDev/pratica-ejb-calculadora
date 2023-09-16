package com.gugawag.pdist.servlets;

import com.gugawag.pdist.ejb.session.MensagemService;
import com.gugawag.pdist.modelo.Mensagem;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/mensagem.do"})
public class MensagemServlet extends jakarta.servlet.http.HttpServlet {

    @EJB(lookup="java:module/mensagemService")
    private MensagemService mensagemService;

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)
            throws jakarta.servlet.ServletException, IOException {
        String operacao = request.getParameter("oper");
        PrintWriter resposta = response.getWriter();
        switch (operacao) {
            case "3": {
                long id = Integer.parseInt(request.getParameter("id"));
                String msg = request.getParameter("conteudo");
                mensagemService.inserir(id, msg);
            }
            case "4": {
                for(Mensagem msg: mensagemService.listar()){
                    resposta.println(msg.getConteudo());
                }
                break;
            }

        }
    }
}
