package br.com.b2w.oracle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.b2w.bean.Pilar;
import br.com.b2w.dao.PilarDao;
import br.com.b2w.exception.EntidadeNaoEncontradaException;
import br.com.b2w.singleton.ConnectionManager;

/**
 * Classe que implementa os métodos existentes da classe PilarDao
 * @author jhona
 *
 */
public class PilarOracleDao implements PilarDao{

	private Connection conn;
	
	/**
	 * Construtor que faz a conexão com o banco de dados
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public PilarOracleDao() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
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
	public PilarOracleDao(Connection conn) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		this.conn = conn;
	}
	
	@Override
	public void cadastrar(Pilar pilar) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO T_PDG_PIL_EST "
				+ " (ID_PILARES, NM_PIL, DS_ATIVO, DT_CRIACAO, DT_DESATIVACAO) VALUES "
				+ " (SQ_PDG_PIL.NEXTVAL, ?, ?, SYSDATE, ?)");
		
		stmt.setString(1, pilar.getNome());
		stmt.setInt(2, pilar.getStatusAtivacao());
		stmt.setString(3, pilar.getDataDesativacao());
		
		stmt.executeUpdate();
		
		stmt.close();
		
	}

	@Override
	public void atualizar(Pilar pilar) throws SQLException, EntidadeNaoEncontradaException {
		PreparedStatement stmt = conn.prepareStatement("UPDATE T_PDG_PIL_EST SET "
				+ " NM_PIL = ?, DS_ATIVO = ?, DT_DESATIVACAO = ? "
				+ " WHERE ID_PILARES = ?");
		
		stmt.setString(1, pilar.getNome());
		stmt.setInt(2, pilar.getStatusAtivacao());
		stmt.setString(3, pilar.getDataDesativacao());
		stmt.setInt(4, pilar.getId());
		
		int qtd = stmt.executeUpdate();
		stmt.close();
		
		if (qtd == 0) {
			throw new EntidadeNaoEncontradaException();
		}
		
	}

	@Override
	public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM T_PDG_PIL_EST WHERE ID_PILARES = ?");
		
		stmt.setInt(1, codigo);
		
		int qtd = stmt.executeUpdate();
		stmt.close();
		
		if (qtd == 0) {
			throw new EntidadeNaoEncontradaException();
		}
		
	}

	@Override
	public List<Pilar> listar() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_PDG_PIL_EST");
		
		List<Pilar> lista = new ArrayList<Pilar>();
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			lista.add(parse(rs));
		}
		
		return lista;
	}

	@Override
	public Pilar pesquisar(int codigo) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_PDG_PIL_EST WHERE ID_PILARES = ?");
		
		stmt.setInt(1, codigo);
		
		Pilar pil = null;
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			pil = parse(rs);
		}
		
		return pil;
	}

	private Pilar parse(ResultSet rs) throws SQLException {
		
		int codigo = rs.getInt("ID_PILARES");
		String nome = rs.getString("NM_PIL");
		int ativo = rs.getInt("DS_ATIVO");
		String dataCriacao = rs.getString("DT_CRIACAO");
		String dataDesativacao = rs.getString("DT_DESATIVACAO");
		
		Pilar pil = new Pilar(codigo, nome, ativo, dataCriacao, dataDesativacao);
		
		return pil;
	}
	
}
