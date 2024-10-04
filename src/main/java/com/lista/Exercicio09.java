package com.lista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/removeNome")
public class Exercicio09 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<String> nomes;

    @Override
    public void init() throws ServletException {
        nomes = new ArrayList<>();
        nomes.add("Ana");
        nomes.add("Maria");
        nomes.add("João");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        
        if (nome != null && !nome.isEmpty()) {
            nomes.remove(nome);
        }

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Lista de Nomes</h1>");
        response.getWriter().println("<ul>");

        for (String n : nomes) {
            response.getWriter().println("<li>" + n + "</li>");
        }

        response.getWriter().println("</ul>");
        response.getWriter().println("</body></html>");
    }
}
