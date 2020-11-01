package br.com.b2w.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.b2w.bean.Pilar;
import br.com.b2w.exception.EntidadeNaoEncontradaException;

public interface PilarDao {

	void cadastrar(Pilar pilar) throws SQLException;
	
	void atualizar(Pilar pilar) throws SQLException, EntidadeNaoEncontradaException;
	
	void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException;
	
	List<Pilar> listar() throws SQLException;
	
	Pilar pesquisar(int codigo) throws SQLException;
}
