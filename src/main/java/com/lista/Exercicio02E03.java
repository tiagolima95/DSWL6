package com.lista;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class Exercicio02E03 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String nome = request.getParameter("nome");

        response.setContentType("text/html;charset=UTF-8");
        
        if (nome != null && !nome.isEmpty()) {
            response.getWriter().write("<h1>Olá, " + nome + "!</h1>");
        } else {
            response.getWriter().write("<h1>Olá, visitante!</h1>");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");

        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().write("<h1>Bem-vindo, " + username + "!</h1>");
    }
}