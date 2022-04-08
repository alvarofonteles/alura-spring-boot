package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "NovoLoginServlet", description = "Novo Servlet", urlPatterns = { "/novoLogin" })
public class NovoLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/** service or doPost */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("O Servlet NovoLoginServlet Started.");

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		PrintWriter out = response.getWriter();
		out.println("<html><body>Login e Senha Cadastrado com Sucesso! <br> Seu Login: " + login + "<br>Sua Senha: "
				+ senha + "</body></html>");

	}

}
