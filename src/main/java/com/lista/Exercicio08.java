package com.lista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/produtos")
public class Exercicio08 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<Produto> produtos;

    @Override
    public void init() throws ServletException {
        produtos = new ArrayList<>();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String precoStr = request.getParameter("preco");
        double preco = Double.parseDouble(precoStr);

        produtos.add(new Produto(nome, preco));

        response.sendRedirect("produtos");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Produtos Cadastrados</h1>");
        response.getWriter().println("<table border='1'><tr><th>Nome</th><th>Preço</th></tr>");
        
        for (Produto produto : produtos) {
            response.getWriter().println("<tr><td>" + produto.getNome() + "</td><td>" + produto.getPreco() + "</td></tr>");
        }
        
        response.getWriter().println("</table>");
        response.getWriter().println("<br><a href='cadastro.html'>Cadastrar Novo Produto</a>");
        response.getWriter().println("</body></html>");
    }
}