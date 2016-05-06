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

@WebServlet("/participacao/filmes")
public class ParticipacaoFilmes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/participacao/listarFilmes.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FilmeServico fs = new FilmeServico();
		List<Filme> itens = fs.buscarTodos();
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
