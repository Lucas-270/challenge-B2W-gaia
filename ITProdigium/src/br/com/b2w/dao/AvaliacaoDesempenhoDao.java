package br.com.b2w.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.b2w.bean.AvaliacaoDesempenho;
import br.com.b2w.exception.EntidadeNaoEncontradaException;

public interface AvaliacaoDesempenhoDao {

	void cadastrar(AvaliacaoDesempenho aval) throws SQLException;
	
	void atualizar(AvaliacaoDesempenho aval) throws SQLException, EntidadeNaoEncontradaException;

	void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException;
	
	List<AvaliacaoDesempenho> listar() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;
	
	List<AvaliacaoDesempenho> listarPorFuncionario(int codigo) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;
	
	AvaliacaoDesempenho pesquisar(int codigo) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;
}
