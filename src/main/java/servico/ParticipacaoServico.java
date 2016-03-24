package servico;

import java.util.List;

import dao.DaoFactory;
import dao.ParticipacaoDao;
import dao.Transaction;
import dominio.Participacao;

public class ParticipacaoServico {

	private ParticipacaoDao dao;
	
	public ParticipacaoServico() {
		dao = DaoFactory.criarParticipacaoDao();
	}
	
	public void inserirAtualizar(Participacao x) {
		try {
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void excluir(Participacao x) {
		try {
			Transaction.begin();
			dao.excluir(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public Participacao buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Participacao> buscarTodos() {
		return dao.buscarTodos();
	}
}
