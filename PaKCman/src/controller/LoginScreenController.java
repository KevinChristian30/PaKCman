package controller;

import model.models.Player;
import utility.PasswordHasher;
import view.MenuScreenView;
import view.RegisterScreenView;

public class LoginScreenController {

	public static void routeToRegisterScreen() {
		
		new RegisterScreenView();
		
	}
	
	public static int attemptLogIn(String username, String password) {
		
		String hashedPassword = PasswordHasher.hash(password);
		Player player = new Player(username, 
				hashedPassword, 0).read();
		
		if (player == null) return -1;
		if (!player.getPlayerPassword().equals(hashedPassword)) return -2;
		routeToMenuScreen(player);
		return 1;
		
	}
	
	private static void routeToMenuScreen(Player player) {
		
		new MenuScreenView(player);
		
	}
	
}
