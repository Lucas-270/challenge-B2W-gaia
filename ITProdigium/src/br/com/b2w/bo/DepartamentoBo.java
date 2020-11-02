package br.com.b2w.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.b2w.bean.Departamento;
import br.com.b2w.exception.EntidadeNaoEncontradaException;
import br.com.b2w.oracle.DepartamentoOracleDao;

public class DepartamentoBo {

	DepartamentoOracleDao depDao;
	
	public void cadastrar(Departamento dep) throws SQLException {
		validar(dep);
		depDao.cadastrar(dep);
	}
	
	public void atualizar(Departamento dep) throws SQLException, EntidadeNaoEncontradaException {
		validar(dep);
		depDao.atualizar(dep);
	}
	
	public Departamento pesquisar(int codigo) throws SQLException {
		return depDao.pequisar(codigo);
	}
	
	public List<Departamento> listar() throws SQLException{
		return depDao.listar();
	}
	
	public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
		depDao.remover(codigo);
	}
	
	private void validar(Departamento dep) {
		
	}
}
