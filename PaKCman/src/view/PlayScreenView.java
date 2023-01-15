package view;

import java.util.ArrayList;
import controller.EndGameScreenController;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import main.Main;
import meta.ColorPalette;
import meta.FontPalette;
import model.Screen;
import model.models.Food;
import model.models.GameMap;
import model.models.Ghost;
import model.models.Pacman;
import model.models.Player;
import utility.SoundPlayer;

public class PlayScreenView extends Screen{
	
	Player player;
	ArrayList<Ghost> ghosts;
	
	BorderPane layoutContainer;
	Canvas canvas;
	GraphicsContext GC;
	
	public static Pacman pacman;
	GameMap gameMap;
	ArrayList<Food> foods;
	
	public static Integer score, lives;
	Label scoreLabel, livesLabel;
	
	GridPane informationContainer;
	
	public PlayScreenView(Player player) {
		
		this.player = player;
		Main.getStage().setHeight(690);
		Main.getStage().setWidth(976);
		
		initiateComponents();
		designLayout();
		setEventHandles();
		setScene();
		
		gameplayLoop();
		
	}

	@Override
	protected void initiateComponents() {
		
		layoutContainer = new BorderPane();
		canvas = new Canvas(Main.getStage().getWidth(), 
				Main.getStage().getHeight() - 100);
		
		GC = canvas.getGraphicsContext2D();
		
		ghosts = new ArrayList<>();
		pacman = new Pacman(35, 35);
		ghosts.add(new Ghost(35, 515, Color.RED, 35, 515));
		ghosts.add(new Ghost(905, 35, Color.LIMEGREEN, 905, 35));
		ghosts.add(new Ghost(905, 515, Color.ORANGE, 905, 515));
		ghosts.add(new Ghost(605, 515, Color.PINK, 605, 515));
		gameMap = new GameMap();

		scene = new Scene(layoutContainer);
		palette = ColorPalette.getInstance();
		
		informationContainer = new GridPane();
		
		score = 0;
		lives = 3;
		
	}

	@Override
	protected void designLayout() {
		
		layoutContainer.setTop(canvas);
		layoutContainer.setBackground(
				new Background(
				new BackgroundFill(Color.BLACK, null, null)));
		layoutContainer.setPrefSize(Main.getStage().getWidth(), Main.getStage().getHeight());
		
		livesLabel = new Label();
		scoreLabel = new Label();
		
		livesLabel.setFont(FontPalette.menuButtonFont);
		livesLabel.setPadding(new Insets(20, 0, 70, 0));
		livesLabel.setTextFill(palette.colorPalette.get("Yellow"));
		
		scoreLabel.setFont(FontPalette.menuButtonFont);
		scoreLabel.setPadding(new Insets(20, 0, 70, 0));
		scoreLabel.setTextFill(palette.colorPalette.get("Yellow"));
		
		informationContainer.add(livesLabel, 0, 0);
		informationContainer.add(scoreLabel, 1, 0);
		layoutContainer.setCenter(informationContainer);
		informationContainer.setHgap(100);
		BorderPane.setMargin(informationContainer, 
				new Insets(-20, 0, 0, 75));
		
		GC.fillRect(0, 0, 100, 100);
		
	}

	@Override
	protected void setEventHandles() {
		
		scene.setOnKeyPressed(e -> {
			
			if (e.getCode() == KeyCode.W ||
				e.getCode() == KeyCode.A ||
				e.getCode() == KeyCode.S ||
				e.getCode() == KeyCode.D || 
				e.getCode() == KeyCode.UP ||
				e.getCode() == KeyCode.DOWN ||
				e.getCode() == KeyCode.LEFT ||
				e.getCode() == KeyCode.RIGHT) pacman.currentKey = e.getCode();
			
			if (e.getCode() == KeyCode.ESCAPE) {
				new MenuScreenView(player);
			}
			
		});
		
	}
	
	private void render(){
		
		gameMap.render(GC);
		pacman.render(GC);
		ghosts.forEach(e -> e.render(GC));
		
	}
	
	private void clear() {
	
		GC.clearRect(0, 0, Main.getStage().getWidth(), Main.getStage().getHeight());
		
	}
	
	private void change() {
		
		livesLabel.setText("Lives: " + lives.toString());
		scoreLabel.setText("Score: " + score.toString());
		pacman.change();
		ghosts.forEach(e -> e.change());
		
	}
	
	private void checkCollideWithEnemy() {
		
		for(Ghost g : ghosts) {
			
			if(pacman.positionX <= g.positionX + g.WIDTH &&
				pacman.positionX + pacman.WIDTH >= g.positionX &&
				pacman.positionY <= g.positionY + g.WIDTH &&
				pacman.positionY + pacman.WIDTH >= g.positionY) {
				
				lives--;
				pacman.positionX = pacman.positionY = 35;
				pacman.currentKey = null;
				
				ghosts.forEach(e -> e.resetPos());
		
			}
			
		}
		
	}
	
	private boolean checkGameFinished() {
		
		return GameMap.foods.isEmpty() || lives <= 0;
		
	}
	
	private void gameplayLoop() {
		
		long then = System.currentTimeMillis();
		final long DELTATIME = 1000 / 60;
		
		AnimationTimer loop = new AnimationTimer() {
			
			@Override
			public void handle(long p) {
				
				long now = System.currentTimeMillis();
				if (now - then >= DELTATIME) {
					
					clear();
					render();
					change();
					checkCollideWithEnemy();
					if (checkGameFinished()) {
						endGame(this);
						EndGameScreenController.routeToVictoryScreen(player, score);
					};
					
					
				}
				
			}
		
		};
		
		loop.start();
		
	}
	
	private void endGame(AnimationTimer loop) {
		loop.stop();
	}
	
}
