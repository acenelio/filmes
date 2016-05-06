package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Filme;
import servico.FilmeServico;

@WebServlet("/filme/resultado")
public class FilmeResultado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/filme/resultadoBusca.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FilmeServico fs = new FilmeServico();
		String titulo = request.getParameter("titulo");
		int anoMin = Integer.parseInt(request.getParameter("anoMin"));
		int anoMax = Integer.parseInt(request.getParameter("anoMax"));
		List<Filme> itens = fs.buscarPorNomeAno(titulo, anoMin, anoMax);
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
