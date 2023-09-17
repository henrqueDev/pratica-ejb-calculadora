package com.gugawag.pdist.servlets;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import models.CalculadoraIF;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/calculadora.do"})
public class CalculadoraEJB extends jakarta.servlet.http.HttpServlet{

    @EJB(lookup = "java:global/calculadora-1.0-SNAPSHOT/calculadoraService")
    private CalculadoraIF calculadora;

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)
            throws jakarta.servlet.ServletException, IOException {
        String firstNumber = request.getParameter("num1");
        String secondNumber = request.getParameter("num2");
        String operacao = request.getParameter("oper");
        PrintWriter resposta = response.getWriter();
        if(operacao.equals("somar")){
            resposta.println(calculadora.somar(Integer.parseInt(firstNumber), Integer.parseInt(secondNumber)));
        }
    }
}
