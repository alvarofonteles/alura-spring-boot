package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @WebServlet("/serverTeste")
 * @author alvarofonteles
 *
 */
public class ServerTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		System.out.println("O Servlet ServerTeste foi chamado.");
		String nome = req.getParameter("nome");

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Olá, " + nome + " bem vindo ao Mundo Servlet!");
		out.println("</body>");
		out.println("</html>");
	}

}
