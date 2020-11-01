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
 * Classe responsável por criar os objetos DAOs da aplicação
 * Utilizando quand temos somente um tipo de banco de dados/fonte de dados
 * @author jhona
 *
 */
// Modificador abstract: (estrutura básica para as classes filhas)
// 1 - Não pode ser instânciado
// 2 - Pode conter métodos abstratos (sem implementação)
public abstract class DaoFactory {

	/**
	 * Retorna uma instância de FuncionarioDao
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
	 * Retorna uma instância de AvaliacaoDesemepnhoDao
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
	 * Retorna uma instância de ObjetivoDao
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
	 * Retorna uma instância de TipoAssociadoDao
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
	 * Retorna uma instância de PilarDao
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
