package br.com.b2w.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.b2w.bean.Pilar;
import br.com.b2w.dao.PilarDao;
import br.com.b2w.oracle.PilarOracleDao;

public class PilarView {

	public static void main(String[] args) {
	
		String nome = JOptionPane.showInputDialog("Informe o nome do pilar");
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código"));
		int statusAtivo = Integer.parseInt(JOptionPane.showInputDialog("Informe o status do pilar\n 1 - Ativo \n 0 - Inativo"));
		LocalDateTime hoje = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		String dataDesativacao = dtf.format(hoje);
		
		Pilar pil = new Pilar(codigo, nome, statusAtivo, null);
		Pilar pil2 = new Pilar(codigo, nome, statusAtivo, dataDesativacao);
		
		try {
			PilarDao pilDao = new PilarOracleDao();
			System.out.println("CADASTRAR");
			pilDao.cadastrar(pil);
			System.out.println("Cadastrado com sucesso!");
			
			System.out.println("ATUALIZAR");
			pilDao.atualizar(pil2);
			System.out.println("Atualizado com sucesso!");
			
			System.out.println("LISTAR");
			List<Pilar> lista = pilDao.listar();
			for (Pilar pilar : lista) {
				System.out.println(pilar);
			}
			
			System.out.println("PESQUISAR");
			pil = pilDao.pesquisar(7);
			System.out.println(pil);
			
			System.out.println("REMOVER");
			pilDao.remover(pil.getId());
			System.out.println("Removido com sucesso");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
