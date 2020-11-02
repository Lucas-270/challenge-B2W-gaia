package br.com.b2w.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.b2w.bean.Pilar;
import br.com.b2w.exception.EntidadeNaoEncontradaException;
import br.com.b2w.oracle.PilarOracleDao;

public class PilarBo {

	PilarOracleDao pilDao;
	
	public void cadastrar(Pilar pil) throws SQLException {
		validar(pil);
		pilDao.cadastrar(pil);
	}
	
	public void atualizar(Pilar pil) throws SQLException, EntidadeNaoEncontradaException {
		validar(pil);
		pilDao.atualizar(pil);
	}
	
	public Pilar pesquisar(int codigo) throws SQLException {
		return pilDao.pesquisar(codigo);
	}
	
	public List<Pilar> listar() throws SQLException{
		return pilDao.listar();
	}
	
	public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
		pilDao.remover(codigo);
	}
	
	private void validar(Pilar pil) {
		
	}
}
