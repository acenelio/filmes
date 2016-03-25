package dao;

import java.util.List;

import dominio.Filme;

public interface FilmeDao {

	public void inserirAtualizar(Filme x);
	public void excluir(Filme x);
	public Filme buscar(int cod);
	public List<Filme> buscarTodos();
	
	public List<Filme> buscarPorNomeAno(String nome, int anoMin, int anoMax);
}
