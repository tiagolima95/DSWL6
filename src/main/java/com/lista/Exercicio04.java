package com.lista;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/contador")
public class Exercicio04 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int contadorAcessos;

    @Override
    public void init() throws ServletException {
        contadorAcessos = 0;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        contadorAcessos++; 
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Contador de Acessos</h1>");
        response.getWriter().println("<p>Este servlet foi acessado " + contadorAcessos + " vezes.</p>");
        response.getWriter().println("</body></html>");
    }
}
