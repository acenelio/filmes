package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Artista;
import dominio.Filme;
import dominio.Participacao;
import servico.ArtistaServico;
import servico.FilmeServico;

@WebServlet("/participacao/novo")
public class ParticipacaoNovo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/participacao/formInserir.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FilmeServico fs = new FilmeServico();
		ArtistaServico as = new ArtistaServico();

		int codFilme = Integer.parseInt(request.getParameter("codFilme"));
		Filme filme = fs.buscar(codFilme);

		Participacao nova = new Participacao();
		nova.setFilme(filme);
		
		List<Artista> artistas = as.buscarTodos();
		
		request.setAttribute("item", nova);
		request.setAttribute("artistas", artistas);
		request.setAttribute("artistaSelecionado", null);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
