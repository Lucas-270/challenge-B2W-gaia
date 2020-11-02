package br.com.b2w.view;

import java.util.List;

import br.com.b2w.bean.AvaliacaoDesempenho;
import br.com.b2w.bean.Funcionario;
import br.com.b2w.dao.AvaliacaoDesempenhoDao;
import br.com.b2w.dao.FuncionarioDao;
import br.com.b2w.oracle.AvaliacaoDesempenhoOracleDao;
import br.com.b2w.oracle.FuncionarioOracleDao;

public class AvaliacaoDesempenhoView {

	public static void main(String[] args) {
	
		Funcionario func = new Funcionario();
		Funcionario gestor = new Funcionario();
		AvaliacaoDesempenho aval = new AvaliacaoDesempenho(
				0, func, 1, 9.5, null, null, "01/11/2020", "07/11/2020", gestor);
		AvaliacaoDesempenho aval2 = new AvaliacaoDesempenho(
				1, func, 2, 7.5, null, null, "01/11/2020", "07/11/2020", gestor);
		
		try {
			AvaliacaoDesempenhoDao avalDao = new AvaliacaoDesempenhoOracleDao();
			FuncionarioDao dao = new FuncionarioOracleDao();
			
			System.out.println("CADASTRAR");
			avalDao.cadastrar(aval);
			System.out.println("Cadastrado com sucesso!");
			
			System.out.println("PESQUISAR");
			aval = avalDao.pesquisar(1);
			System.out.println(aval);
			
			System.out.println("ATUALIZAR");
			avalDao.atualizar(aval2);
			System.out.println("Atualizado com sucesso!!");
			
			System.out.println("LISTAR");
			List<AvaliacaoDesempenho> lista = avalDao.listar();
			for (AvaliacaoDesempenho avaliacaoDesempenho : lista) {
				System.out.println(avaliacaoDesempenho);
			}
			
			System.out.println("LISTAR POR FUNCIONÁRIO");
			List<AvaliacaoDesempenho> lista2 = avalDao.listarPorFuncionario(13);
			for (AvaliacaoDesempenho avaliacaoDesempenho : lista2) {
				System.out.println(avaliacaoDesempenho);
			}
			
			System.out.println("REMOVER");
			avalDao.remover(1);
			System.out.println("Removido com sucesso!");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
