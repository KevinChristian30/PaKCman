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
import model.models.Pacman;
import model.models.Player;

public class PlayScreenView extends Screen{
	
	Player player;
	
	BorderPane layoutContainer;
	Canvas canvas;
	GraphicsContext GC;
	
	Pacman pacman;
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
		
		pacman = new Pacman(35, 35);
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
		
	}
	
	private void clear() {
	
		GC.clearRect(0, 0, Main.getStage().getWidth(), Main.getStage().getHeight());
		
	}
	
	private void change() {
		
		livesLabel.setText("Lives: " + lives.toString());
		scoreLabel.setText("Score: " + score.toString());
		pacman.change();
		
	}
	
	
	private void checkGameFinished() {
		
		if (GameMap.foods.isEmpty()) {
			EndGameScreenController.routeToVictoryScreen();
		}
		
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
					checkGameFinished();
					
				}
				
			}
		
		};
		
		loop.start();
		
	}
	
}
