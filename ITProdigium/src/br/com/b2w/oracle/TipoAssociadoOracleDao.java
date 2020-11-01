package br.com.b2w.oracle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.b2w.bean.TipoAssociado;
import br.com.b2w.dao.TipoAssociadoDao;
import br.com.b2w.exception.EntidadeNaoEncontradaException;
import br.com.b2w.singleton.ConnectionManager;

public class TipoAssociadoOracleDao implements TipoAssociadoDao{

	private Connection conn;
	
	//Construtor que obtem a conexao com o BD
	public TipoAssociadoOracleDao() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		conn = ConnectionManager.getInstance().getConnection();
	}
	
	public TipoAssociadoOracleDao(Connection conn) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		this.conn = conn;
	}
	
	@Override
	public void cadastrar(TipoAssociado tipo) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO T_PDG_ROLES "
				+ " (ID_ROLE, NM_ROLE) VALUES (SQ_PDG_ROLE.NEXTVAL, ?)");
		
		stmt.setString(1, tipo.getNome());
		
		stmt.executeUpdate();
		
		stmt.close();
		
	}

	@Override
	public void atualizar(TipoAssociado tipo) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("UPDATE T_PDG_ROLES SET "
				+ " NM_ROLE = ? WHERE ID_ROLE = ?");
		
		stmt.setString(1, tipo.getNome());
		stmt.setInt(2, tipo.getId());
		
		stmt.executeUpdate();
		
		stmt.close();
		
	}

	@Override
	public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM T_PDG_ROLES WHERE ID_ROLE = ?");
		
		stmt.setInt(1, codigo);
		
		int qtd = stmt.executeUpdate();
		stmt.close();
		
		if (qtd == 0) {
			throw new EntidadeNaoEncontradaException();
		}
		
	}

	@Override
	public List<TipoAssociado> listar() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_PDG_ROLES");
		
		List<TipoAssociado> lista = new ArrayList<TipoAssociado>();
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			lista.add(parse(rs));
		}
		stmt.close();
		
		return lista;
	}

	@Override
	public TipoAssociado pesquisar(int codigo) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_PDG_ROLES WHERE ID_ROLE = ?");
		
		stmt.setInt(1, codigo);
		
		TipoAssociado tipo = null;
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			tipo = parse(rs);
		}
		stmt.close();
		
		return tipo;
	}

	private TipoAssociado parse(ResultSet rs) throws SQLException {
		
		int codigo = rs.getInt("ID_ROLE");
		String nome = rs.getString("NM_ROLE");
		int nvlAcesso = 0;
		switch(codigo) {
			case 1:
				nvlAcesso = 1;
			case 2:
				nvlAcesso = 2;
			case 3:
				nvlAcesso = 3;
			default:
				nvlAcesso = 0;
		}
		
		TipoAssociado tipo = new TipoAssociado(codigo, nvlAcesso, nome);
		
		return tipo;
		
	}
	
}
