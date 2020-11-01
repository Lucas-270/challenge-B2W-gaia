package br.com.b2w.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	//1- Atributo est�tico que armazena a �nica inst�ncia
	private static ConnectionManager manager;
	
	//Atributo que possui as informa�oes do arquivo banco.properties
	private Properties prop;
		
	//2- Construtor privado (Nenhuma outra classe pode instanciar a ConnectionManager)
	private ConnectionManager() throws FileNotFoundException, IOException {
		//Carregar o arquivo banco.properties no att prop
		prop = new Properties();
		prop.load(new FileInputStream("./funcionalidade/banco.properties"));
	}
	
	//3- M�todo est�tico que retorna a �nica inst�ncia
	public static ConnectionManager getInstance() throws FileNotFoundException, IOException {
		if (manager == null) {
			manager = new ConnectionManager();
		}
		return manager;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		//Registrar o driver no BD
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Obter a conex�o com o BD
		Connection conn = DriverManager
				.getConnection( prop.getProperty("url"),
								prop.getProperty("usuario"),
								prop.getProperty("senha"));
		
		return conn;
	}
}
