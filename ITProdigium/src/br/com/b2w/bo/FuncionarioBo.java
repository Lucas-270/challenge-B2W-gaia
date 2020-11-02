package br.com.b2w.bo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.b2w.bean.Funcionario;
import br.com.b2w.exception.EntidadeNaoEncontradaException;
import br.com.b2w.oracle.FuncionarioOracleDao;

public class FuncionarioBo {

	FuncionarioOracleDao dao;
	
	public void cadastrar(Funcionario func) throws SQLException {
		validar(func);
		dao.cadastrar(func);
	}
	
	public void atualizar(Funcionario func) throws SQLException, EntidadeNaoEncontradaException {
		validar(func);
		dao.atualizar(func);
	}
	
	public Funcionario pesquisar(int codigo) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		return dao.pesquisar(codigo);
	}
	
	public List<Funcionario> listar() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		return dao.listar();
	}
	
	public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
		dao.remover(codigo);
	}
	
	private void validar(Funcionario func) {
		
	}
	
}
