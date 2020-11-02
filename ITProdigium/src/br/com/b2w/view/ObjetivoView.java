package br.com.b2w.view;

import java.util.ArrayList;
import java.util.List;

import br.com.b2w.bean.AvaliacaoDesempenho;
import br.com.b2w.bean.Objetivo;
import br.com.b2w.bean.Pilar;
import br.com.b2w.dao.AvaliacaoDesempenhoDao;
import br.com.b2w.dao.ObjetivoDao;
import br.com.b2w.dao.PilarDao;
import br.com.b2w.oracle.AvaliacaoDesempenhoOracleDao;
import br.com.b2w.oracle.ObjetivoOracleDao;
import br.com.b2w.oracle.PilarOracleDao;

public class ObjetivoView {

	public static void main(String[] args) {
		
		AvaliacaoDesempenho aval = new AvaliacaoDesempenho();
		Pilar pil = new Pilar();
		Objetivo obj = new Objetivo(0, aval, 1, "Cliente", pil, "Melhorar ambiente de trabalho", "todos", "20/12/2020");
		Objetivo obj2 = new Objetivo(0, aval, 1, "Empresa", pil, "Melhorar ambiente de trabalho", "Seleto", "20/12/2020");
		
		try {
			ObjetivoDao objDao = new ObjetivoOracleDao();
			AvaliacaoDesempenhoDao avalDao = new AvaliacaoDesempenhoOracleDao();
			PilarDao pilDao = new PilarOracleDao();
			aval = avalDao.pesquisar(1);
			pil = pilDao.pesquisar(1);
			
			System.out.println("CADASTRAR");
			objDao.cadastrar(obj);
			System.out.println("Cadastrado com sucesso!!");
			
			System.out.println("PESQUISAR");
			obj = objDao.pesquisar(1);
			System.out.println(obj);
			
			System.out.println("ATUALIZAR");
			objDao.atualizar(obj2);
			System.out.println("Atualizado com sucesso!!");
			
			System.out.println("LISTAR");
			List<Objetivo> lista = new ArrayList<Objetivo>();
			for (Objetivo objetivo : lista) {
				System.out.println(objetivo);
			}
			
			System.out.println("LISTAR POR FUNCIONÁRIO");
			List<Objetivo> lista2 = new ArrayList<Objetivo>();
			for (Objetivo objetivo : lista2) {
				System.out.println(objetivo);
			}
			
			System.out.println("REMOVER");
			objDao.remover(1);
			System.out.println("Removido com sucesso!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
