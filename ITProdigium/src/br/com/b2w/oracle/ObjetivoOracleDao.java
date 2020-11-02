package br.com.b2w.oracle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.b2w.bean.AvaliacaoDesempenho;
import br.com.b2w.bean.Objetivo;
import br.com.b2w.bean.Pilar;
import br.com.b2w.dao.AvaliacaoDesempenhoDao;
import br.com.b2w.dao.ObjetivoDao;
import br.com.b2w.dao.PilarDao;
import br.com.b2w.exception.EntidadeNaoEncontradaException;
import br.com.b2w.singleton.ConnectionManager;

/**
 * Classe que implementa os métodos existentes dentro da classe ObjetivoDao
 * @author jhona
 *
 */
public class ObjetivoOracleDao implements ObjetivoDao{

	private Connection conn;
	
	/**
	 * Construtor que faz a conexão com o banco de dados
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public ObjetivoOracleDao() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		conn = ConnectionManager.getInstance().getConnection();
	}
	
	/**
	 * Construtor que recebe a conexão para o banco de dados
	 * @param conn - Conexão com o BD
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public ObjetivoOracleDao(Connection conn) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		this.conn = conn;
	}
	
	
	@Override
	public void cadastrar(Objetivo objetivo) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO T_PDG_OBJS "
				+ " (ID_OBJETIVOS, ID_ASSOCIADO, ID_AVALIACAO, ID_PILARES, ID_STt_OBJ, ID_STT_AVAL"
				+ "	ID_GESTOR, NM_GESTOR, NM_OBJ, NM_PESSOA, DS_METODOS, DS_RESUL, DS_META, DT_PRAZO, DT_CRIACAO"
				+ "	DT_APROVACAO, NT_AUTOAVAL, DT_AUTOAVAL, NT_AVAL, DT_AVAL, DT_CONFIRMACAO) VALUES "
				+ " (SQ_PDG_OBJS.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, ?, ?, ?)");
		
		stmt.setInt(1, objetivo.getAval().getFunc().getCodigo());
		stmt.setInt(2, objetivo.getAval().getCodigo());
		stmt.setInt(3, objetivo.getPilar().getId());
		stmt.setInt(4, objetivo.getStatus());
		stmt.setInt(5, objetivo.getAval().getStatus());
		stmt.setInt(6, objetivo.getAval().getCriadorAval().getCodigo());
		stmt.setString(7, objetivo.getAval().getCriadorAval().getNome());
		stmt.setString(8, objetivo.getNome());
		stmt.setString(9, objetivo.getPessoa());
		stmt.setString(10, objetivo.getMetodos());
		stmt.setString(11, objetivo.getResultado());
		stmt.setString(12, objetivo.getMeta());
		stmt.setString(13, objetivo.getDataPrazo());
		stmt.setString(14, objetivo.getDataAprovacao());
		stmt.setDouble(15, objetivo.getAutoNota());
		stmt.setString(16, objetivo.getDataAutoNota());
		stmt.setDouble(17, objetivo.getNotaGestor());
		stmt.setString(18, objetivo.getDataNotaGestor());
		stmt.setString(19, objetivo.getDataConfirmacao());
		
		stmt.executeUpdate();
		
		stmt.close();
	}

	@Override
	public void atualizar(Objetivo objetivo) throws SQLException, EntidadeNaoEncontradaException {
		PreparedStatement stmt = conn.prepareStatement("UPDATE T_PDG_OBJS SET "
				+ " ID_ASSOCIADO = ?, ID_AVALIACAO = ?, ID_PILARES = ?, ID_STATUS_OBJETIVOS = ?, ID_STT_AVAL = ?"
				+ "	ID_GESTOR = ?, NM_GESTOR = ?, NM_OBJ = ?, NM_PESSOA = ?, DS_METODOS = ?, DS_RESUL = ?, DS_META = ?, DT_PRAZO = ?, "
				+ "	DT_APROVACAO = ?, NT_AUTOAVAL = ?, DT_AUTOAVAL = ?, NT_AVAL = ?, DT_AVAL = ?, DT_CONFIRMACAO = ? "
				+ " WHERE ID_OBJETIVOS = ?");
		
		stmt.setInt(1, objetivo.getAval().getFunc().getCodigo());
		stmt.setInt(2, objetivo.getAval().getCodigo());
		stmt.setInt(3, objetivo.getPilar().getId());
		stmt.setInt(4, objetivo.getStatus());
		stmt.setInt(5, objetivo.getAval().getStatus());
		stmt.setInt(6, objetivo.getAval().getCriadorAval().getCodigo());
		stmt.setString(7, objetivo.getAval().getCriadorAval().getNome());
		stmt.setString(8, objetivo.getNome());
		stmt.setString(9, objetivo.getPessoa());
		stmt.setString(10, objetivo.getMetodos());
		stmt.setString(11, objetivo.getResultado());
		stmt.setString(12, objetivo.getMeta());
		stmt.setString(13, objetivo.getDataPrazo());
		stmt.setString(14, objetivo.getDataAprovacao());
		stmt.setDouble(15, objetivo.getAutoNota());
		stmt.setString(16, objetivo.getDataAutoNota());
		stmt.setDouble(17, objetivo.getNotaGestor());
		stmt.setString(18, objetivo.getDataNotaGestor());
		stmt.setString(19, objetivo.getDataConfirmacao());
		stmt.setInt(20, objetivo.getCodigo());
		
		int qtd = stmt.executeUpdate();
		stmt.close();
		
		if (qtd == 0) {
			throw new EntidadeNaoEncontradaException();
		}
	}

	@Override
	public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM T_PDG_OBJS WHERE ID_OBJETIVOS = ?");
		
		stmt.setInt(1, codigo);
		
		int qtd = stmt.executeUpdate();
		stmt.close();
		
		if (qtd == 0) {
			throw new EntidadeNaoEncontradaException();
		}
	}

	@Override
	public List<Objetivo> listar() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_PDG_OBJS");
		
		List<Objetivo> lista = new ArrayList<Objetivo>();
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			lista.add(parse(rs));
		}
		stmt.close();
		
		return lista;
	}

	@Override
	public List<Objetivo> listarPorFuncionario(int codigo) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_PDG_OBJS WHERE ID_ASSOCIADO = ?");
		
		stmt.setInt(1, codigo);
		
		List<Objetivo> lista = new ArrayList<Objetivo>();
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			lista.add(parse(rs));
		}
		stmt.close();
		
		return lista;
	}

	@Override
	public Objetivo pesquisar(int codigo) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_PDG_OBJS WHERE ID_OBJETIVOS = ?");
		
		Objetivo obj = new Objetivo();
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			obj = parse(rs);
		}
		stmt.close();
		
		return obj;
	}

	private Objetivo parse(ResultSet rs) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		
		int codigo = rs.getInt("ID_OBJETIVOS");
		int codFunc = rs.getInt("ID_ASSOCIADO");
		int codAval = rs.getInt("ID_AVALIACAO"); 
		int codPil = rs.getInt("ID_PILARES"); 
		int codSttObj = rs.getInt("ID_STATUS_OBJETIVOS"); 
		int codStt = rs.getInt("ID_STT_AVAL");
		int codGestor = rs.getInt("ID_GESTOR");
		String nomeGestor = rs.getString("NM_GESTOR"); 
		String nomeObj = rs.getString("NM_OBJ"); 
		String nomePessoa = rs.getString("NM_PESSOA"); 
		String nomeMetodos = rs.getString("DS_METODOS"); 
		String resul = rs.getString("DS_RESUL"); 
		String dataPrazo = rs.getString("DT_PRAZO");
		String dataCriacao = rs.getString("DT_CRIACAO");
		String dataAprovacao = rs.getString("DT_APROVACAO"); 
		double autoNota = rs.getDouble("NT_AUTOAVAL"); 
		String dataAutoAval = rs.getString("DT_AUTOAVAL");
		double notaGestor = rs.getDouble("NT_AVAL"); 
		String dataNotaGestor = rs.getString("DT_AVAL"); 
		String dataConfirmacao = rs.getString("DT_CONFIRMACAO");
		
		AvaliacaoDesempenhoDao avalDao = new AvaliacaoDesempenhoOracleDao();
		AvaliacaoDesempenho aval = avalDao.pesquisar(codAval);
		
		PilarDao pilDao = new PilarOracleDao();
		Pilar pil = pilDao.pesquisar(codPil);
		
		Objetivo objetivo = new Objetivo(codigo, aval, codSttObj, nomeObj, resul, nomeMetodos, nomePessoa, 
						pil, dataPrazo, dataCriacao, dataAprovacao, autoNota, dataAutoAval, notaGestor, dataNotaGestor, dataConfirmacao);
		
		return objetivo;
	}	
}
