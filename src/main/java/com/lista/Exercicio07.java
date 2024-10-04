package com.lista;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/acesso")
public class Exercicio07 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Map<String, Integer> contadorAcessos;

    @Override
    public void init() throws ServletException {
        contadorAcessos = new HashMap<>();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        if (nome == null || nome.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "O parâmetro 'nome' é obrigatório.");
            return;
        }

        contadorAcessos.put(nome, contadorAcessos.getOrDefault(nome, 0) + 1);

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Contador de Acessos por Usuário</h1>");
        response.getWriter().println("<p>Usuário: " + nome + "</p>");
        response.getWriter().println("<p>Este usuário acessou a página " + contadorAcessos.get(nome) + " vezes.</p>");
        response.getWriter().println("</body></html>");
    }
}
