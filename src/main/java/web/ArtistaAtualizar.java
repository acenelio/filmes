package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Artista;
import servico.ArtistaServico;
import servico.ServicoException;
import servico.ValidacaoException;

@WebServlet("/artista/atualizar")
public class ArtistaAtualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/artista/listar.jsp";
	private static String FORM = "/artista/formEditar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArtistaServico as = new ArtistaServico();
		Artista x = Instanciar.artista(request);
		try {
			as.validar(x);
			as.atualizar(x);
			List<Artista> itens = as.buscarTodosOrdenadosPorNome();
			request.setAttribute("itens", itens);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		} catch (ValidacaoException e) {
			request.setAttribute("erros", e.getErros());
			request.setAttribute("item", x);
			request.getRequestDispatcher(FORM).forward(request, response);
		}
	}
}
