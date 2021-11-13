package model.dataccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	final static String URL = "jdbc:postgresql://localhost:5432/authentication";

	final static String USER = "postgres";

	final static String PWD = "root";
	
	public static Connection connect() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conection;
		try {
			conection = DriverManager.getConnection(URL, USER, PWD);
			return conection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	
}
