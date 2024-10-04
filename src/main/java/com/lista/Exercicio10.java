package com.lista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tarefas")
public class Exercicio10 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<String> tarefas;

    @Override
    public void init() throws ServletException {
        tarefas = new ArrayList<>();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String tarefa = request.getParameter("tarefa");
        if (tarefa != null && !tarefa.isEmpty()) {
            tarefas.add(tarefa);
        }
        
        response.sendRedirect("tarefas");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Lista de Tarefas</h1>");
        response.getWriter().println("<form action='tarefas' method='post'>");
        response.getWriter().println("<label for='tarefa'>Nova Tarefa:</label>");
        response.getWriter().println("<input type='text' id='tarefa' name='tarefa' required>");
        response.getWriter().println("<input type='submit' value='Adicionar Tarefa'>");
        response.getWriter().println("</form><br>");

        response.getWriter().println("<h2>Tarefas Cadastradas:</h2>");
        response.getWriter().println("<ul>");
        for (String tarefa : tarefas) {
            response.getWriter().println("<li>" + tarefa + "</li>");
        }
        response.getWriter().println("</ul>");
        response.getWriter().println("</body></html>");
    }
}
