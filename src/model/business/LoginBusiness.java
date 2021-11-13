package model.business;

import java.sql.SQLException;

import model.dataccess.LoginDataAccess;
import model.entities.MessageException;
import model.entities.User;
import view.LoginSuccessView;

public class LoginBusiness {
	private User user;
	private LoginDataAccess loginDataAccess;
	
public boolean validation(String userName, String password) throws MessageException, ClassNotFoundException, SQLException{
	if (userName.equals("")) {
		throw new MessageException("Username not informed.");
	} else if (password.equals("")) {
		throw new MessageException("Password not informed.");
	} 
	if(this.user == null) {
		this.user = new User(userName, password);
	} else {
		this.user.setUserName(userName);
		this.user.setPassword(password);
	}
	
	
	
		if(this.loginDataAccess== null) {
			 this.loginDataAccess = new LoginDataAccess();
		}
		if (!(this.loginDataAccess.verifyCredentials(this.user))) {
			throw new MessageException("Incorrect credentials.");
		}  else {
				
				return true;
			}
	
}
}
