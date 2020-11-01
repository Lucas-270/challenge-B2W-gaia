package br.com.b2w.view;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.b2w.bean.Departamento;
import br.com.b2w.dao.DepartamentoDao;
import br.com.b2w.oracle.DepartamentoOracleDao;

public class DepartamentoView {

	public static void main(String[] args) {
		
		String nome = JOptionPane.showInputDialog("Informe o nome do departamento");
		Departamento dep = new Departamento(0, nome);
		Departamento dep2 = new Departamento(10, "Comercial");
		
		try {
			DepartamentoDao depDao = new DepartamentoOracleDao();
			System.out.println("CADASTRAR");
			depDao.cadastrar(dep);
			System.out.println("Cadastrado com sucesso!");
			
			System.out.println("PESQUISAR");
			dep = depDao.pequisar(10);
			System.out.println(dep);
			
			System.out.println("ATUALIZAR");
			depDao.atualizar(dep2);
			System.out.println("Atualizado com sucesso!");
			
			System.out.println("LISTAR");
			List<Departamento> lista = depDao.listar();
			for (Departamento departamento : lista) {
				System.out.println(departamento);
			}
			
			System.out.println("REMOVER");
			depDao.remover(10);
			System.out.println("Removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
