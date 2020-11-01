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
import br.com.b2w.bean.Funcionario;
import br.com.b2w.bean.TipoAssociado;
import br.com.b2w.dao.DepartamentoDao;
import br.com.b2w.dao.FuncionarioDao;
import br.com.b2w.dao.TipoAssociadoDao;
import br.com.b2w.exception.EntidadeNaoEncontradaException;
import br.com.b2w.singleton.ConnectionManager;

public class FuncionarioOracleDao implements FuncionarioDao{
	
private Connection conn;
	
	//Construtor que obtem a conexao com o BD
	public FuncionarioOracleDao() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		conn = ConnectionManager.getInstance().getConnection();
	}
	
	@Override
	public void cadastrar(Funcionario func) throws SQLException{
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO T_PDG_ASSOC "
				+ " (ID_ASSOCIADO, ID_ROLE, ID_DEP, DS_CARGO, NM_GESTOR, NM_ASSOC, DS_SENHA, DS_EMAIL, DT_CADASTRO, DT_DESATIVACAO, DS_ATIVO) VALUES"
				+ " (SQ_PDG_ASSOC.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?)");
		
		stmt.setInt(1, func.getTipo().getId());
		stmt.setInt(2, func.getDep().getId());
		stmt.setString(3, func.getCargo());
		stmt.setString(4, func.getGestor());
		stmt.setString(5, func.getNome());
		stmt.setString(6, func.getSenha());
		stmt.setString(7, func.getEmail());
		stmt.setString(8, func.getDataDesativacao());
		stmt.setInt(9, func.getIsActive());
	
		stmt.executeUpdate();
		
		stmt.close();
	}

	@Override
	public void atualizar(Funcionario func) throws SQLException, EntidadeNaoEncontradaException {
		PreparedStatement stmt = conn.prepareStatement("UPDATE T_PDG_ASSOC SET "
				+ " ID_ROLE = ?, ID_DEP = ?, DS_CARGO = ?, NM_GESTOR = ?, "
				+ " NM_ASSOC = ?, DS_SENHA = ?, DS_EMAIL = ?, DT_DESATIVACAO = ?, "
				+ " DS_ATIVO = ? WHERE ID_ASSOCIADO = ?");
		
		stmt.setInt(1, func.getTipo().getId());
		stmt.setInt(2, func.getDep().getId());
		stmt.setString(3, func.getCargo());
		stmt.setString(4, func.getGestor());
		stmt.setString(5, func.getNome());
		stmt.setString(6, func.getSenha());
		stmt.setString(7, func.getEmail());
		stmt.setString(8, func.getDataDesativacao());
		stmt.setInt(9, func.getIsActive());
		stmt.setInt(10, func.getCodigo());
		
		int qtd = stmt.executeUpdate();
		stmt.close();
		
		if (qtd == 0) {
			throw new EntidadeNaoEncontradaException();
		}
	}

	@Override
	public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM T_PDG_ASSOC WHERE ID_ASSOCIADO = ?");
		
		stmt.setInt(1, codigo);
		
		int qtd = stmt.executeUpdate();
		stmt.close();
		
		if (qtd == 0) {
			throw new EntidadeNaoEncontradaException();
		}
	}

	@Override
	public List<Funcionario> listar() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_PDG_ASSOC");
		
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			lista.add(parse(rs));
		}
		
		return lista;
	}

	@Override
	public Funcionario pesquisar(int codigo) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_PDG_ASSOC WHERE ID_ASSOCIADO = ?");
		
		stmt.setInt(1, codigo);
		
		Funcionario func = new Funcionario();
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			func = parse(rs);
		}
		
		return func;
	}

	private Funcionario parse(ResultSet rs) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		
		int codigo = rs.getInt("ID_ASSOCIADO"); 
		int roles = rs.getInt("ID_ROLE");
		int codigoDep = rs.getInt("ID_DEP");
		String cargo = rs.getString("DS_CARGO"); 
		String gestor = rs.getString("NM_GESTOR"); 
		String nome = rs.getString("NM_ASSOC"); 
		String senha = rs.getString("DS_SENHA"); 
		String email = rs.getString("DS_EMAIL"); 
		String dataCadastro = rs.getString("DT_CADASTRO"); 
		String dataDesativacao = rs.getString("DT_DESATIVACAO"); 
		int ativo = rs.getInt("DS_ATIVO");
		
		DepartamentoDao depDao = new DepartamentoOracleDao(conn);
		Departamento dep = depDao.pequisar(codigoDep);
		
		TipoAssociadoDao tipoDao = new TipoAssociadoOracleDao(conn);
		TipoAssociado tipo = tipoDao.pesquisar(roles);
		
		Funcionario func = new Funcionario(codigo, nome, cargo, gestor, dep, tipo, email, senha, dataCadastro, dataDesativacao, ativo);
		
		return func;
	}
	
}
