package br.com.b2w.bo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.b2w.bean.AvaliacaoDesempenho;
import br.com.b2w.exception.EntidadeNaoEncontradaException;
import br.com.b2w.oracle.AvaliacaoDesempenhoOracleDao;

public class AvaliacaoDesempenhoBo {

	AvaliacaoDesempenhoOracleDao avalDao;
	
	public void cadastrar(AvaliacaoDesempenho aval) throws SQLException {
		validar(aval);
		avalDao.cadastrar(aval);
	}
	
	public void atualizar(AvaliacaoDesempenho aval) throws SQLException, EntidadeNaoEncontradaException {
		validar(aval);
		avalDao.atualizar(aval);
	}
	
	public AvaliacaoDesempenho pesquisar(int codigo) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		return avalDao.pesquisar(codigo);
	}
	
	public List<AvaliacaoDesempenho> listar() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		return avalDao.listar();
	}
	
	public List<AvaliacaoDesempenho> listarPorFunc(int codigo) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		return avalDao.listarPorFuncionario(codigo);
	}
	
	public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
		avalDao.remover(codigo);
	}
	
	private void validar(AvaliacaoDesempenho aval) {
		
	}
}
