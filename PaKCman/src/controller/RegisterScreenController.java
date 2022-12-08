package controller;

import model.models.Player;
import utility.PasswordHasher;
import view.LoginScreenView;

public class RegisterScreenController {

	public static void routeToLoginScreen() {
		
		new LoginScreenView();
		
	}
	
	public static boolean attemptRegister(String username, String password) {
			
		String hashedPassword = PasswordHasher.hash(password);
		Player player = new Player(username, hashedPassword, 0).read();
		
		if (player != null) return false;
		else {
			
			new Player(username, hashedPassword, 0).create();
			return true;
		
		}
		
	}
	
}
