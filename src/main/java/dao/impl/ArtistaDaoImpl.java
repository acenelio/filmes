package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ArtistaDao;
import dominio.Artista;

public class ArtistaDaoImpl implements ArtistaDao {

	private EntityManager em;

	public ArtistaDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Artista x) {
		if (x.getCodArtista() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Artista x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Artista buscar(int cod) {
		return em.find(Artista.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Artista> buscarTodos() {
		String jpql = "SELECT x FROM Artista x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Artista> buscarTodosOrdenadosPorNome() {
		String jpql = "SELECT x FROM Artista x ORDER BY x.nome";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Artista buscaNomeExato(String nome) {
		String jpql = "SELECT x FROM Artista x WHERE x.nome = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", nome);
		List<Artista> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Artista buscaNomeExatoDiferente(Integer codigo, String nome) {
		String jpql = "SELECT x FROM Artista x WHERE x.codArtista <> :p0 AND x.nome = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p0", codigo);
		query.setParameter("p1", nome);
		List<Artista> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Artista> buscarPorNome(String trecho) {
		String jpql = "SELECT x FROM Artista x WHERE x.nome LIKE :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", "%"+trecho+"%");
		return query.getResultList();
	}
}
