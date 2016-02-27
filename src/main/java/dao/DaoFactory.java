package dao;

import dao.impl.ArtistaDaoImpl;
import dao.impl.FilmeDaoImpl;
import dao.impl.ParticipacaoDaoImpl;

public class DaoFactory {

	public static ArtistaDao criarArtistaDao() {
		return new ArtistaDaoImpl();
	}

	public static FilmeDao criarFilmeDao() {
		return new FilmeDaoImpl();
	}

	public static ParticipacaoDao criarParticipacaoDao() {
		return new ParticipacaoDaoImpl();
	}
}
