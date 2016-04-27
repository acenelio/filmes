package web;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import dominio.Artista;

public class Instanciar {

	public static Artista artista(HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Artista aux = new Artista();
		String s;

		s = request.getParameter("codArtista");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setCodArtista(Integer.parseInt(s));
			} catch (NumberFormatException e) {
				e.printStackTrace();
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
				e.printStackTrace();
			}
		}

		s = request.getParameter("nascimento");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setNascimento(sdf.parse(s));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return aux;
	}
}
