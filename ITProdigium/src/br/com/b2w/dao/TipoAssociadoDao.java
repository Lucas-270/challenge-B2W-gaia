package br.com.b2w.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.b2w.bean.TipoAssociado;
import br.com.b2w.exception.EntidadeNaoEncontradaException;

public interface TipoAssociadoDao {

	void cadastrar(TipoAssociado tipo) throws SQLException;
	
	void atualizar(TipoAssociado tipo) throws SQLException;
	
	void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException;
	
	List<TipoAssociado> listar() throws SQLException;
	
	TipoAssociado pesquisar(int codigo) throws SQLException;
}
