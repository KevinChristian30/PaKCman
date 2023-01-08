package view;

import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import main.Main;
import meta.ColorPalette;
import model.Screen;
import model.models.GameMap;
import model.models.Pacman;
import model.models.Player;

public class PlayScreenView extends Screen{
	
	Player player;
	
	StackPane layoutContainer;
	Canvas canvas;
	GraphicsContext GC;
	
	Pacman pacman;
	GameMap gameMap;
	
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
		
		layoutContainer = new StackPane();
		canvas = new Canvas(Main.getStage().getWidth(), Main.getStage().getHeight());
		GC = canvas.getGraphicsContext2D();
		
		pacman = new Pacman(35, 35);
		gameMap = new GameMap();

		scene = new Scene(layoutContainer);
		palette = ColorPalette.getInstance();
		
	}

	@Override
	protected void designLayout() {
		
		layoutContainer.getChildren().add(canvas);
		
		layoutContainer.setBackground(
				new Background(
				new BackgroundFill(Color.BLACK, null, null)));
		layoutContainer.setPrefSize(Main.getStage().getWidth(), Main.getStage().getHeight());
		layoutContainer.setAlignment(Pos.TOP_LEFT);
		
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
		
		pacman.change();
		
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
					
				}
				
			}
		
		};
		
		loop.start();
		
	}
	
}
