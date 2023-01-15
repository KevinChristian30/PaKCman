package controller;

import model.models.Player;
import view.MenuScreenView;

public class VictoryScreenController {

	public static void routeToMainMenuScreen(Player player) {
		
		new MenuScreenView(player);
		
	}
	
}
