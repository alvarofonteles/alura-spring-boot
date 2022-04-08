package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** oi */
/**
 * @WebServlet(urlPatterns = "/oi")
 * @author alvarofonteles
 *
 */
public class OiMundoServlet extends HttpServlet {

	public OiMundoServlet() {
		System.out.println("Criado O Servlet OiMundoServlet.");
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Olá Mundo Servlet!?");
		out.println("</body>");
		out.println("</html>");

		System.out.println("O Servlet OiMundoServlet foi chamado.");
	}
}