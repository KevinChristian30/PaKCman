package model.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import utility.Connect;

public class Player implements Model {

	private String playerName;
	private String playerPassword;
	private int playerHighScore;
	
	public Player() {};
	
	public Player(String playerName, String playerPassword, 
			int playerHighScore) {
		
		super();
		this.playerName = playerName;
		this.playerPassword = playerPassword;
		this.playerHighScore = playerHighScore;
		
	}

	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public String getPlayerPassword() {
		return playerPassword;
	}
	
	public void setPlayerPassword(String playerPassword) {
		this.playerPassword = playerPassword;
	}
	
	public int getPlayerHighScore() {
		return playerHighScore;
	}
	
	public void setPlayerHighScore(int playerHighScore) {
		this.playerHighScore = playerHighScore;
	}

	@Override
	public void create() {
		
		Connect connection = Connect.getInstance();
		String query = "INSERT INTO MsPlayer VALUES('%s', '%s', '%d');";
		query = String.format(query, this.playerName, 
				this.playerPassword, this.playerHighScore);
		
		connection.executeUpdate(query);
		
	}

	@Override
	public Player read() {
		
		Connect connection = Connect.getInstance();
		String query = "SELECT * FROM MsPlayer "
				+ "		WHERE PlayerName = '%s';";
		query = String.format(query, this.playerName, this.playerPassword);
		ResultSet result = connection.executeQuery(query);
		
		try {
			
			if (result.next()) {
				
				String playerName = result.getString("PlayerName");
				String password = result.getString("PlayerPassword");
				int highScore = result.getInt("PlayerHighScore");
			
				return new Player(playerName, password, highScore);
				
			}
			
		} catch (SQLException e) {}
		
		return null;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void delete() {
		
	}
	
}
