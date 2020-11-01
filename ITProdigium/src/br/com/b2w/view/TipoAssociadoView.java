package br.com.b2w.view;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.b2w.bean.TipoAssociado;
import br.com.b2w.dao.TipoAssociadoDao;
import br.com.b2w.oracle.TipoAssociadoOracleDao;

public class TipoAssociadoView {

	public static void main(String[] args) {
		
		String nome = JOptionPane.showInputDialog("Informe o nome do cargo");
		
		TipoAssociado tipo = new TipoAssociado(0, nome);
		TipoAssociado tipo2 = new TipoAssociado(4, "Administrador");
		
		try {
			TipoAssociadoDao tipoDao = new TipoAssociadoOracleDao();
			System.out.println("CADASTRAR");
			//tipoDao.cadastrar(tipo);
			System.out.println("Cadastrado com sucesso!!");
			
			System.out.println("ATUALIZAR");
			//tipoDao.atualizar(tipo2);
			System.out.println("Atualizado com sucesso!!");
			
			System.out.println("PESQUISAR");
			tipo = tipoDao.pesquisar(4);
			System.out.println(tipo);
			
			System.out.println("LISTAR");
			List<TipoAssociado> lista = tipoDao.listar();
			for (TipoAssociado tipoAssociado : lista) {
				System.out.println(tipoAssociado);
			}
			
			System.out.println("REMOVER");
			tipoDao.remover(tipo.getId());
			System.out.println("Removido com sucesso");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
