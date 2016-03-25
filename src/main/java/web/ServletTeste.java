package web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Filme;
import servico.ArtistaServico;
import servico.FilmeServico;
import servico.ParticipacaoServico;

@WebServlet("/ServletTeste")
public class ServletTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.parse("01/01/2000");

			ArtistaServico as = new ArtistaServico();
			FilmeServico fs = new FilmeServico();
			ParticipacaoServico ps = new ParticipacaoServico();

/*
			// Tentando inserir um artista com nome repetido:
			
			Artista a1 = new Artista(null, "Leonardo Di Caprio", "US", new BigDecimal("2000000.00"), sdf.parse("20/03/2016"));
			try {
				as.inserir(a1);
				response.getWriter().append("Leonardo Di Caprio inserido!\n");
			}
			catch (ServicoException e) {
				response.getWriter().append(e.getMessage()+"\n");
			}
*/			

			
/*
			// Tentando atualizar um artista (1):
			Artista a1 = as.buscar(1);
			try {
				a1.setCache(a1.getCache().add(new BigDecimal("1.00")));
				as.atualizar(a1);
				response.getWriter().append("Artista atualizado!\n");
			}
			catch (ServicoException e) {
				response.getWriter().append(e.getMessage()+"\n");
			}
*/
/*			

			// Tentando atualizar um artista (2):
			Artista a1 = as.buscar(1);
			try {
				a1.setNome("Cate Blanchett");
				as.atualizar(a1);
				response.getWriter().append("Artista atualizado!\n");
			}
			catch (ServicoException e) {
				response.getWriter().append(e.getMessage()+"\n");
			}

*/		
/*			
			// Tentando inserir uma participacao nao repetida:
			
			Filme f1 = fs.buscar(2);
			Artista a1 = as.buscar(1);
			Participacao p = new Participacao(null, "Joaozinho", new BigDecimal("0.00"), f1, a1);
			try {
				ps.inserir(p);
				response.getWriter().append("Participacao inserida!\n");
			}
			catch (ServicoException e) {
				response.getWriter().append(e.getMessage());
			}
		
*/
/*			
			// Tentando inserir uma participacao repetida:
			
			Filme f1 = fs.buscar(2);
			Artista a1 = as.buscar(1);
			Participacao p = new Participacao(null, "Jack Dawson", new BigDecimal("0.00"), f1, a1);
			try {
				ps.inserir(p);
				response.getWriter().append("Participacao inserida!\n");
			}
			catch (ServicoException e) {
				response.getWriter().append(e.getMessage());
			}

*/			

			// Realizando a consulta de filmes:
			List<Filme> lista = fs.buscarPorNomeAno("o", 1997, 2010);
			for (Filme x : lista) {
				response.getWriter().append(x + "\n");
			}
			
			
		}
		catch (ParseException e) {
			response.getWriter().append("Data inválida!");
		}
	}
}
