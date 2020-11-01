package br.com.b2w.factory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import br.com.b2w.dao.AvaliacaoDesempenhoDao;
import br.com.b2w.dao.FuncionarioDao;
import br.com.b2w.dao.ObjetivoDao;
import br.com.b2w.dao.PilarDao;
import br.com.b2w.dao.TipoAssociadoDao;
import br.com.b2w.oracle.AvaliacaoDesempenhoOracleDao;
import br.com.b2w.oracle.FuncionarioOracleDao;
import br.com.b2w.oracle.ObjetivoOracleDao;
import br.com.b2w.oracle.PilarOracleDao;
import br.com.b2w.oracle.TipoAssociadoOracleDao;

/**
 * Classe respons�vel por criar os objetos DAOs da aplica��o
 * Utilizando quand temos somente um tipo de banco de dados/fonte de dados
 * @author jhona
 *
 */
// Modificador abstract: (estrutura b�sica para as classes filhas)
// 1 - N�o pode ser inst�nciado
// 2 - Pode conter m�todos abstratos (sem implementa��o)
public abstract class DaoFactory {

	/**
	 * Retorna uma inst�ncia de FuncionarioDao
	 * @return FuncionarioOracleDao
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static FuncionarioDao getFuncionario() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		return new FuncionarioOracleDao();
	}
	
	/**
	 * Retorna uma inst�ncia de AvaliacaoDesemepnhoDao
	 * @return AvaliacaoDesempenhoOracleDao
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static AvaliacaoDesempenhoDao getAvaliacaoDesempenho() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		return new AvaliacaoDesempenhoOracleDao();
	}
	
	/**
	 * Retorna uma inst�ncia de ObjetivoDao
	 * @return ObjetivoOracleDao
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static ObjetivoDao getObjetivo() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		return new ObjetivoOracleDao();
	}
	
	/**
	 * Retorna uma inst�ncia de TipoAssociadoDao
	 * @return TipoAssociadoOracleDao
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static TipoAssociadoDao getTipoAssociado() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		return new TipoAssociadoOracleDao();
	}
	
	/**
	 * Retorna uma inst�ncia de PilarDao
	 * @return PilarOracleDao
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static PilarDao getPilar() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		return new PilarOracleDao();
	}
	
}
