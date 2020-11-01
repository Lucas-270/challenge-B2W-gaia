package br.com.b2w.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.b2w.bean.Departamento;
import br.com.b2w.bean.Funcionario;
import br.com.b2w.bean.TipoAssociado;
import br.com.b2w.dao.DepartamentoDao;
import br.com.b2w.dao.FuncionarioDao;
import br.com.b2w.dao.TipoAssociadoDao;
import br.com.b2w.oracle.DepartamentoOracleDao;
import br.com.b2w.oracle.FuncionarioOracleDao;
import br.com.b2w.oracle.TipoAssociadoOracleDao;

public class FuncionarioView {

	public static void main(String[] args) {
		
		String nome = JOptionPane.showInputDialog("Insira o nome funcionário");
		String cargo = JOptionPane.showInputDialog("Informe o cargo do funcionário na empresa");
		String gestor = JOptionPane.showInputDialog("Informe o nome completo do gestor do funcionário");
		String email = JOptionPane.showInputDialog("Informe o email do funcionário");
		String senha = JOptionPane.showInputDialog("Informe a senha do funcionário");
		int ativo = Integer.parseInt(JOptionPane.showInputDialog("Informe se o funcionário está ativo\n 1 - ativo\n 0 - Inativo"));
		LocalDateTime hoje = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		String dataDesativacao = dtf.format(hoje);
		
		Funcionario func = new Funcionario(0, nome, cargo, gestor, null, null, email,  senha, null, null, ativo);
		Funcionario func2 = new Funcionario(88, "Claisson", "Operário", "Irineu da Silva Pinto", null, null, "clai.sson@uol.com.br", "cl@l$$0N", dataDesativacao, 0);
		
		try {
			FuncionarioDao dao = new FuncionarioOracleDao();
			DepartamentoDao depDao = new DepartamentoOracleDao();
			TipoAssociadoDao tipoDao = new TipoAssociadoOracleDao();
			Departamento dep = depDao.pequisar(2);
			TipoAssociado tipo = tipoDao.pesquisar(1);
			func.setDep(dep);
			func.setTipo(tipo);
			func2.setDep(dep);
			func2.setTipo(tipo);
			
			System.out.println("CADASTRAR");
			//dao.cadastrar(func);
			System.out.println("Cadastrado com sucesso");
			
			System.out.println("PESQUISAR");
			//func = dao.pesquisar(88);
			//System.out.println(func);
			
			System.out.println("ATUALIZAR");
			dao.atualizar(func2);
			System.out.println("Atualizado com sucesso!");
			
			System.out.println("LISTAR");
			List<Funcionario> lista = dao.listar();
			for (Funcionario funcionario : lista) {
				System.out.println(funcionario);
			}
			
			System.out.println("REM0VER");
			dao.remover(80);
			System.out.println("Removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
