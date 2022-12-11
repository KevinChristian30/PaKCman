package controller;

import model.models.Player;
import view.MenuScreenView;

public class OptionsScreenController {

	public static void routeToMenuSreen(Player player) {
		
		new MenuScreenView(player);
		
	}
	
}
