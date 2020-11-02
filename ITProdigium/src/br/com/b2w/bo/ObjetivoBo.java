package br.com.b2w.bo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.b2w.bean.Objetivo;
import br.com.b2w.exception.EntidadeNaoEncontradaException;
import br.com.b2w.oracle.ObjetivoOracleDao;

public class ObjetivoBo {

	ObjetivoOracleDao objDao;
	
	public void cadastrar(Objetivo obj) throws SQLException {
		validar(obj);
		objDao.cadastrar(obj);
	}
	
	public void atualizar(Objetivo obj) throws SQLException, EntidadeNaoEncontradaException {
		validar(obj);
		objDao.atualizar(obj);
	}
	
	public Objetivo pesquisar(int codigo) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		return objDao.pesquisar(codigo);
	}
	
	public List<Objetivo> listar() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		return objDao.listar();
	}
	
	public List<Objetivo> listar(int codigo) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		return objDao.listarPorFuncionario(codigo);
	}
	
	public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
		objDao.remover(codigo);
	}
	
	private void validar(Objetivo obj) {
		
	}
}
