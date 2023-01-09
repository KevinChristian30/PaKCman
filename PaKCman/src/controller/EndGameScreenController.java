package controller;

import view.DefeatScreenView;
import view.VictoryScreenView;

public class EndGameScreenController {

	public static void routeToVictoryScreen() {
		
		new VictoryScreenView();
		
	}
	
	public static void routeToDefeatScreen() {
		
		new DefeatScreenView();
		
	}
	
}
