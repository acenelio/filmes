package web;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import dominio.Artista;
import dominio.Filme;
import dominio.Participacao;
import servico.ArtistaServico;
import servico.FilmeServico;

public class Instanciar {

	public static Participacao participacao(HttpServletRequest request) {
		
		ArtistaServico as = new ArtistaServico();
		FilmeServico fs = new FilmeServico();
		
		Participacao aux = new Participacao();
		String s;
		
		s = request.getParameter("codParticipacao");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setCodParticipacao(Integer.parseInt(s));
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: codParticipacao invalido");
			}
		}

		s = request.getParameter("personagem");
		if (s != null && !s.isEmpty()) {
			aux.setPersonagem(s);
		}

		s = request.getParameter("desconto");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setDesconto(new BigDecimal(s));
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: desconto invalido");
			}
		}

		s = request.getParameter("codArtista");
		if (s != null && !s.isEmpty()) {
			try {
				Artista x = as.buscar(Integer.parseInt(s));
				aux.setArtista(x);
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: codArtista invalido");
			}
		}

		s = request.getParameter("codFilme");
		if (s != null && !s.isEmpty()) {
			try {
				Filme x = fs.buscar(Integer.parseInt(s));
				aux.setFilme(x);
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: codArtista invalido");
			}
		}

		return aux;
	}
	
	
	public static Artista artista(HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Artista aux = new Artista();
		String s;

		s = request.getParameter("codArtista");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setCodArtista(Integer.parseInt(s));
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: codArtista invalido");
			}
		}

		s = request.getParameter("nome");
		if (s != null && !s.isEmpty()) {
			aux.setNome(s);
		}

		s = request.getParameter("nacionalidade");
		if (s != null && !s.isEmpty()) {
			aux.setNacionalidade(s);
		}

		s = request.getParameter("cache");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setCache(new BigDecimal(s));
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: cache invalido");
			}
		}

		s = request.getParameter("nascimento");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setNascimento(sdf.parse(s));
			} catch (ParseException e) {
				System.out.println("Instanciacao: nascimento invalido");
			}
		}

		return aux;
	}	
}
