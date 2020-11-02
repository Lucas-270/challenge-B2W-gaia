package br.com.b2w.oracle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.b2w.bean.Departamento;
import br.com.b2w.dao.DepartamentoDao;
import br.com.b2w.exception.EntidadeNaoEncontradaException;
import br.com.b2w.singleton.ConnectionManager;

/**
 * Classe que implementa os métodos existentes da classe DepartamentoDao
 * @author jhona
 *
 */
public class DepartamentoOracleDao implements DepartamentoDao{

	private Connection conn;
	
	/**
	 * Construtor que faz a conexão com o banco de dados
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public DepartamentoOracleDao() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
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
	public DepartamentoOracleDao(Connection conn) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		this.conn = conn;
	}
	
	@Override
	public void cadastrar(Departamento dep) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO T_PDG_DEP "
				+ " (ID_DEP, NM_DEP) VALUES (SQ_PDG_DEP.NEXTVAL, ?)");
		
		stmt.setString(1, dep.getNome());
		
		stmt.executeUpdate();
		
		stmt.close();
		
	}

	@Override
	public void atualizar(Departamento dep) throws SQLException, EntidadeNaoEncontradaException {
		PreparedStatement stmt = conn.prepareStatement("UPDATE T_PDG_DEP SET "
				+ " NM_DEP = ? WHERE ID_DEP = ?");
		
		stmt.setString(1, dep.getNome());
		stmt.setInt(2, dep.getId());
		
		int qtd = stmt.executeUpdate();
		stmt.close();
		
		if (qtd == 0) {
			throw new EntidadeNaoEncontradaException();
		}
		
	}

	@Override
	public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM T_PDG_DEP WHERE ID_DEP = ?");
		
		stmt.setInt(1, codigo);
		
		int qtd = stmt.executeUpdate();
		stmt.close();
		
		if (qtd == 0) {
			throw new EntidadeNaoEncontradaException();
		}
		
	}

	@Override
	public List<Departamento> listar() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_PDG_DEP");
		
		List<Departamento> lista = new ArrayList<Departamento>();
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			lista.add(parse(rs));
		}
		
		return lista;
	}

	@Override
	public Departamento pequisar(int codigo) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_PDG_DEP WHERE ID_DEP = ?");
		
		stmt.setInt(1, codigo);
		
		Departamento dep = null;
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			dep = parse(rs);
		}
		
		return dep;
	}

	private Departamento parse(ResultSet rs) throws SQLException {
		
		int codigo = rs.getInt("ID_DEP");
		String nome = rs.getString("NM_DEP");
		
		Departamento dep = new Departamento(codigo, nome);
		
		return dep;
	}
	
}
