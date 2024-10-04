package com.lista;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addNome") 
public class Exercicio05 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ArrayList<String> nomes = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
     
        String nome = request.getParameter("nome");
        
        if (nome != null && !nome.isEmpty()) {
            nomes.add(nome);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        out.println("<h1>Nomes Armazenados:</h1>");
        out.println("<ul>");
        for (String n : nomes) {
            out.println("<li>" + n + "</li>");
        }
        out.println("</ul>");

        out.println("<form action='addNome' method='GET'>");
        out.println("Nome: <input type='text' name='nome' required>");
        out.println("<button type='submit'>Adicionar</button>");
        out.println("</form>");
    }
}