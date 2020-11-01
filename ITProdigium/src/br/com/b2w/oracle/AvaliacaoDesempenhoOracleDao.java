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
import br.com.b2w.bean.Funcionario;
import br.com.b2w.bean.Objetivo;
import br.com.b2w.dao.AvaliacaoDesempenhoDao;
import br.com.b2w.dao.FuncionarioDao;
import br.com.b2w.dao.ObjetivoDao;
import br.com.b2w.exception.EntidadeNaoEncontradaException;
import br.com.b2w.singleton.ConnectionManager;

public class AvaliacaoDesempenhoOracleDao implements AvaliacaoDesempenhoDao{

	private Connection conn;
	
	//Construtor que obtem a conexao com o BD
	public AvaliacaoDesempenhoOracleDao() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		conn = ConnectionManager.getInstance().getConnection();
	}
	
	@Override
	public void cadastrar(AvaliacaoDesempenho aval) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO T_PDG_AVAL_DES "
				+ " (ID_AVALIACAO, ID_ASSOCIADO, ID_STT_AVAL, ID_GESTOR, NM_GESTOR, NT_AVAL, DT_CRIACAO, DT_AVAL, DT_CONFIRMACAO, DT_ABERTURA_CADOBJETIVOS, DT_FECHAMENTO_CADOBJETIVOS) VALUES "
				+ " (SQ_PDG_AVAL.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		stmt.setInt(1, aval.getFunc().getCodigo());
		stmt.setInt(2, aval.getStatus());
		stmt.setInt(3, aval.getCriadorAval().getCodigo());
		stmt.setString(4, aval.getCriadorAval().getNome());
		stmt.setDouble(5, aval.getNota());
		stmt.setString(6, aval.getDataCriacao());
		stmt.setString(7, aval.getDataAvaliacao());
		stmt.setString(8, aval.getDataCadObjs());
		stmt.setString(9, aval.getDataFecObjs());
		
		stmt.executeUpdate();
		
		stmt.close();
		
	}

	@Override
	public void atualizar(AvaliacaoDesempenho aval) throws SQLException, EntidadeNaoEncontradaException {
		PreparedStatement stmt = conn.prepareStatement("UPDATE T_PDG_AVAL_DES SET "
				+ " ID_ASSOCIADO = ?, ID_STT_AVAL = ?, ID_GESTOR = ?, NM_GESTOR = ?, NT_AVAL = ?, DT_CRIACAO = ?"
				+ " DT_AVAL = ?, DT_CONFIRMACAO = ?, DT_ABERTURA_CADOBJETIVOS = ?, DT_FECHAMENTO_CADOBJETIVOS = ?"
				+ " WHERE ID_AVALIACAO = ?");
		
		stmt.setInt(1, aval.getFunc().getCodigo());
		stmt.setInt(2, aval.getStatus());
		stmt.setInt(3, aval.getCriadorAval().getCodigo());
		stmt.setString(4, aval.getCriadorAval().getNome());
		stmt.setDouble(5, aval.getNota());
		stmt.setString(6, aval.getDataCriacao());
		stmt.setString(7, aval.getDataAvaliacao());
		stmt.setString(8, aval.getDataCadObjs());
		stmt.setString(9, aval.getDataFecObjs());
		stmt.setInt(10, aval.getCodigo());
		
		int qtd = stmt.executeUpdate();
		stmt.close();
		
		if (qtd == 0) {
			throw new EntidadeNaoEncontradaException();
		}
		
	}

	@Override
	public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM T_PDG_AVAL_DES WHERE ID_AVALIACAO = ?");
		
		stmt.setInt(1, codigo);
		
		int qtd = stmt.executeUpdate();
		stmt.close();
		
		if (qtd == 0) {
			throw new EntidadeNaoEncontradaException();
		}
		
	}

	@Override
	public List<AvaliacaoDesempenho> listar() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_PDG_AVAL_DES");
		
		List<AvaliacaoDesempenho> lista = new ArrayList<AvaliacaoDesempenho>();
		
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			lista.add(parse(rs));
		}
		stmt.close();
		
		return lista;
	}
	
	@Override
	public List<AvaliacaoDesempenho> listarPorFuncionario(int codigo) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_PDG_AVAL_DES WHERE ID_ASSOCIADO = ?");
		
		List<AvaliacaoDesempenho> lista = new ArrayList<AvaliacaoDesempenho>();
		
		stmt.setInt(1, codigo);
		
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			lista.add(parse(rs));
		}
		stmt.close();
		
		return lista;
	}

	@Override
	public AvaliacaoDesempenho pesquisar(int codigo) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_PDG_AVAL_DES WHERE ID_AVALIACAO = ?");
		
		AvaliacaoDesempenho aval = null;
		
		stmt.setInt(1, codigo);
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			aval = parse(rs);
		}
		stmt.close();
		
		return aval;
	}

	private AvaliacaoDesempenho parse(ResultSet rs) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		
		int codigo = rs.getInt("ID_AVALIACAO");
		int codFunc = rs.getInt("ID_ASSOCIADO");
		int codStatus = rs.getInt("ID_STT_AVAL");
		int codGestor = rs.getInt("ID_GESTOR");
		String nomeGestor = rs.getString("NM_GESTOR");
		double notaAval = rs.getDouble("NT_AVAL");
		String dataCriacao = rs.getString("DT_CRIACAO");
		String dataAval = rs.getString("DT_AVAL");
		String dataConfirmacao = rs.getString("DT_CONFIRMACAO");
		String dataAberturaCadObjetivos = rs.getString("DT_ABERTURA_CADOBEJTIVOS");
		String dataFechamentoCadObjetivos = rs.getString("DT_FECHAMENTO_CADOBJETIVOS");
		
		FuncionarioDao dao = new FuncionarioOracleDao();
		Funcionario func = dao.pesquisar(codFunc);
		
		Funcionario gestor = dao.pesquisar(codGestor);
		gestor.setNome(nomeGestor);
		
		ObjetivoDao objDao = new ObjetivoOracleDao();
		List<Objetivo> listaObjs = objDao.listarPorFuncionario(codFunc);
		
		AvaliacaoDesempenho aval = new AvaliacaoDesempenho(codigo, func, codStatus, notaAval, dataCriacao, 
									dataAval, dataConfirmacao, listaObjs, dataAberturaCadObjetivos, 
									dataFechamentoCadObjetivos, gestor);
		
		return aval;
	}
	
}
