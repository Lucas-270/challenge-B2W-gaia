package br.com.b2w.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.b2w.bean.Departamento;
import br.com.b2w.exception.EntidadeNaoEncontradaException;

/**
 * Define os métodos que serão implementados para a classe Departamento
 * @author jhona
 *
 */
public interface DepartamentoDao {

	void cadastrar(Departamento dep) throws SQLException;
	
	void atualizar(Departamento dep) throws SQLException, EntidadeNaoEncontradaException;
	
	void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException;
	
	List<Departamento> listar() throws SQLException;
	
	Departamento pequisar(int codigo) throws SQLException;
}
