package com.lista;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addComentario")
public class Exercicio06 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ArrayList<String> comentarios = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String comentario = request.getParameter("comentario");

        if (comentario != null && !comentario.isEmpty()) {
            comentarios.add(comentario);
        }

        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        out.println("<h1>Comentários:</h1>");
        out.println("<ul>");
        for (String c : comentarios) {
            out.println("<li>" + c + "</li>");
        }
        out.println("</ul>");
    }
}