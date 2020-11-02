package br.com.b2w.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.b2w.bean.Objetivo;
import br.com.b2w.exception.EntidadeNaoEncontradaException;

/**
 * Classe que define os métodos que serão implementados para a classe Objetivo
 * @author jhona
 *
 */
public interface ObjetivoDao {

	void cadastrar(Objetivo objetivo) throws SQLException;
	
	void atualizar(Objetivo objetivo) throws SQLException, EntidadeNaoEncontradaException;
	
	void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException;
	
	List<Objetivo> listar() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	
	List<Objetivo> listarPorFuncionario(int codigo) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;
	
	Objetivo pesquisar(int codigo) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;
}
