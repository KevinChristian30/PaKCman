package controller;

import model.models.Player;
import view.MenuScreenView;

public class LeaderboardScreenController {
	
	public static void routeToMenuScreen(Player player) {
		
		new MenuScreenView(player);
		
	}
	
}
