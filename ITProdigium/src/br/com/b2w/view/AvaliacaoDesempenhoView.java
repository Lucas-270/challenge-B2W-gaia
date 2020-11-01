package br.com.b2w.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import br.com.b2w.dao.AvaliacaoDesempenhoDao;
import br.com.b2w.oracle.AvaliacaoDesempenhoOracleDao;

public class AvaliacaoDesempenhoView {

	public static void main(String[] args) {
		
		try {
			AvaliacaoDesempenhoDao avalDao = new AvaliacaoDesempenhoOracleDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
