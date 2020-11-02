package br.com.b2w.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.b2w.bean.Funcionario;
import br.com.b2w.exception.EntidadeNaoEncontradaException;

/**
 * Classe que define os métodos que serão implementados para a classe Funcionario
 * @author jhona
 *
 */
public interface FuncionarioDao {

	void cadastrar(Funcionario func) throws SQLException;
	
	void atualizar(Funcionario func) throws SQLException, EntidadeNaoEncontradaException;
	
	void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException;
	
	List<Funcionario> listar() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;
	
	Funcionario pesquisar(int codigo) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;
}
