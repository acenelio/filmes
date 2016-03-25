package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ParticipacaoDao;
import dominio.Artista;
import dominio.Filme;
import dominio.Participacao;

public class ParticipacaoDaoImpl implements ParticipacaoDao {

	private EntityManager em;

	public ParticipacaoDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Participacao x) {
		if (x.getCodParticipacao() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Participacao x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Participacao buscar(int cod) {
		return em.find(Participacao.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Participacao> buscarTodos() {
		String jpql = "SELECT x FROM Participacao x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Participacao buscarExato(String personagem, Artista artista, Filme filme) {
		String jpql = "SELECT x FROM Participacao x WHERE x.personagem = :p1 AND x.artista = :p2 AND x.filme = :p3";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", personagem);
		query.setParameter("p2", artista);
		query.setParameter("p3", filme);
		List<Participacao> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Participacao buscarExatoDiferente(Integer codigo, String personagem, Artista artista, Filme filme) {
		String jpql = "SELECT x FROM Participacao x WHERE x.codParticipacao <> :p0 AND x.personagem = :p1 AND x.artista = :p2 AND x.filme = :p3";
		Query query = em.createQuery(jpql);
		query.setParameter("p0", codigo);
		query.setParameter("p1", personagem);
		query.setParameter("p2", artista);
		query.setParameter("p3", filme);
		List<Participacao> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}
	
}
