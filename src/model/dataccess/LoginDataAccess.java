package model.dataccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entities.User;

public class LoginDataAccess {

	public Boolean verifyCredentials(User user) throws ClassNotFoundException, SQLException {
/*
		final String URL = "jdbc:postgresql://localhost:5432/authentication";

		final String USER = "postgres";

		final String PWD = "root";

		Class.forName("org.postgresql.Driver");
		Connection conection = DriverManager.getConnection(URL, USER, PWD);
*/
		Connection conection = ConnectionFactory.connect();
		final PreparedStatement stmt = conection.prepareStatement("SELECT * FROM users WHERE username=? and password=?");

		stmt.setString(1, user.getUserName());
		stmt.setString(2, user.getPassword());

		ResultSet rs = stmt.executeQuery();

		return rs.next();
		
	}

}

