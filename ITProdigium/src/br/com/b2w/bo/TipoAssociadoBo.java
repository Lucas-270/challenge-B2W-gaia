package br.com.b2w.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.b2w.bean.TipoAssociado;
import br.com.b2w.exception.EntidadeNaoEncontradaException;
import br.com.b2w.oracle.TipoAssociadoOracleDao;

public class TipoAssociadoBo {

	TipoAssociadoOracleDao tipoDao;
	
	public void cadastrar(TipoAssociado tipo) throws SQLException {
		validar(tipo);
		tipoDao.cadastrar(tipo);
	}
	
	public void atualizar(TipoAssociado tipo) throws SQLException {
		validar(tipo);
		tipoDao.atualizar(tipo);
	}
	
	public TipoAssociado pesquisar(int codigo) throws SQLException {
		return tipoDao.pesquisar(codigo);
	}
	
	public List<TipoAssociado> listar() throws SQLException{
		return tipoDao.listar();
	}
	
	public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
		tipoDao.remover(codigo);
	}
	
	private void validar(TipoAssociado tipo) {
		
	}
}
