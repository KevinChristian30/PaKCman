package controller;

import java.util.ArrayList;
import java.util.Collections;

import model.models.Player;
import view.LeaderboardScreenView;
import view.LoginScreenView;

public class MenuScreenController {

	public static void routeToLoginScreen() {
		
		new LoginScreenView();
		
	}
	
	public static void routeToLeaderboardScreen() {
		
		ArrayList<Player> players = Player.readAll();
		
		Collections.sort(players, (a, b) -> b.getPlayerHighScore() - a.getPlayerHighScore());
		
		new LeaderboardScreenView(players);
		
	}
	
}
