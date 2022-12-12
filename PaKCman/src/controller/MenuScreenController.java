package controller;

import java.util.ArrayList;
import java.util.Collections;

import model.models.Player;
import view.LeaderboardScreenView;
import view.LoginScreenView;
import view.OptionsScreenView;
import view.PlayScreenView;

public class MenuScreenController {

	public static void routeToLoginScreen() {
		
		new LoginScreenView();
		
	}
	
	public static void routeToLeaderboardScreen(Player player) {
		
		ArrayList<Player> players = Player.readAll();
		
		Collections.sort(players, (a, b) -> b.getPlayerHighScore() - a.getPlayerHighScore());
		
		new LeaderboardScreenView(players, player);
		
	}
	
	public static void routeToOptionsScreen(Player player) {
		
		new OptionsScreenView(player);
		
	}
	
	public static void routeToPlayScreen(Player player) {
		
		new PlayScreenView(player);
		
	}
	
}
