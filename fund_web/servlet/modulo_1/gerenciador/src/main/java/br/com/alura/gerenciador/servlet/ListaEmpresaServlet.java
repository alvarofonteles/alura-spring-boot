package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @WebServlet(description = "Lista de Empresas", urlPatterns = { "/listaEmpresas" })
 * @author alvarofonteles
 *
 */
public class ListaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		request.setAttribute("empresas", lista);
    
		//response.sendRedirect("listaEmpresas.jsp"); 
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		rd.forward(request, response);

		/**
		 * out.println("<html><body>"); out.println("
		 * <ul>
		 * ");
		 * 
		 * for (Empresa empresa : lista) { request.setAttribute("nomeEmpresa",
		 * empresa.getNome()); out.println("
		 * <li>" + empresa.getNome() + "</li>"); }
		 * 
		 * out.println("
		 * </ul>
		 * "); out.println("</html></body>");
		 */
	}

}
