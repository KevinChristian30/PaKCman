package controller;

import model.models.Player;
import view.DefeatScreenView;
import view.VictoryScreenView;

public class EndGameScreenController {

	public static void routeToVictoryScreen(Player player, int score) {
		
		new VictoryScreenView(player, score);
		
	}
	
}
