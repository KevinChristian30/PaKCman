package model.models;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import main.Main;
import meta.ColorPalette;

public class GameMap extends GameObject{
	
	ArrayList<Wall> walls = new ArrayList<>();

	private final int WIDTH = 25;
	
	public GameMap(){
		
		walls.add(new Wall(0, 0, WIDTH, Main.getStage().getHeight()));
		walls.add(new Wall(0, 0, Main.getStage().getWidth(), WIDTH));
		walls.add(new Wall(Main.getStage().getWidth() - WIDTH - 16, 0, 
				WIDTH, Main.getStage().getHeight()));
		walls.add(new Wall(0, Main.getStage().getHeight() - WIDTH - 39,
				Main.getStage().getWidth(), WIDTH));
		
	}
	
	@Override
	public void render(GraphicsContext GC) {
		
		walls.forEach(e -> {
			
			GC.setFill(ColorPalette.getInstance().colorPalette.get("Blue"));
			GC.fillRect(e.positionX, e.positionY, e.width, e.height);
			
		});
		
	}

}
