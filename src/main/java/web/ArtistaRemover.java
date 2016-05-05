package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Artista;
import servico.ArtistaServico;

@WebServlet("/artista/remover")
public class ArtistaRemover extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/artista/confirmarExclusao.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArtistaServico as = new ArtistaServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Artista art = as.buscar(cod);
		request.setAttribute("item", art);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
