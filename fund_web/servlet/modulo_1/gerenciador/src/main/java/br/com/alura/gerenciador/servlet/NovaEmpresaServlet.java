package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @WebServlet(name = "NovaEmpresaServlet", description = "Novo Servlet", urlPatterns = { "/novaEmpresa" })
 * @author alvarofonteles
 *
 */
public class NovaEmpresaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/** service or doPost */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("O Servlet NovaEmpresaServlet Started.");

		String nomeEmpresa = request.getParameter("nomeEmpresa");
		String paramDataAbertura = request.getParameter("dataAbertura");

		Date dataAbertura;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);

		Banco banco = new Banco();
		banco.adiciona(empresa);

		PrintWriter out = response.getWriter();
		/**
		 * out.println("<html><body>Empresa " + nomeEmpresa + ", Cadastrada com
		 * Sucesso!(Aula Anterior)<br>
		 * " + "Empresa " + empresa.getNome() + ", Cadastrada com
		 * Sucesso!</body></html>");
		 */

		// Chama JSP
		request.setAttribute("nomeEmpresa", empresa.getNome());
		request.setAttribute("dataAbertura", empresa.getDataAbertura());
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		rd.forward(request, response);
		
		response.sendRedirect("listaEmpresas");
	}

}
