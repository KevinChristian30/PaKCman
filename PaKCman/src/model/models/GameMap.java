package model.models;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import meta.ColorPalette;

public class GameMap extends GameObject{
	
	public static ArrayList<Wall> walls = new ArrayList<>();
	public static ArrayList<Food> foods = new ArrayList<>();

	private final int WIDTH = 30;
	
	public static final String[] map = {
		"################################",
		"#                              #",
		"#  ########  #####  #########  #",
		"#                              #",
		"#         ###  ##  ###         #",
		"#  #####  ###  ##  ###  #####  #",
		"#  #####                #####  #",
		"#                              #",
		"          ###  ##  ###          ",
		"      #######  ##  #######      ",
		"          ###  ##  ###          ",
		"#                              #",
		"#  #####                #####  #",
		"#  #####  ###  ##  ###  #####  #",
		"#         ###  ##  ###         #",
		"#                              #",
		"#  ########  #####  #########  #",
		"#                              #",
		"################################"
	};
	
	public GameMap(){
		
		for (int i = 0; i < 19; i++)
			for (int j = 0; j < 32; j++) {
				if (map[i].charAt(j) == '#') {
					walls.add(new Wall(j * WIDTH, i * WIDTH));
				} else {
					foods.add(new Food(j * WIDTH, i * WIDTH));
				}
			}
		
	}
	
	@Override
	public void render(GraphicsContext GC) {
		
		walls.forEach(e -> {
			
			GC.setFill(ColorPalette.getInstance().colorPalette.get("Blue"));
			GC.fillRect(e.positionX, e.positionY, WIDTH, WIDTH);
			
		});
		
		foods.forEach(e -> {
			
			GC.setFill(Color.YELLOW);
			GC.fillArc(e.getPositionX() + WIDTH / 2 - Food.FOODWIDTH / 2, 
					e.getPositionY() + WIDTH / 2 - Food.FOODWIDTH / 2, 
					Food.FOODWIDTH, Food.FOODWIDTH, 
					0, Math.toDegrees(2 * Math.PI), ArcType.ROUND);
			
		});
		
	}

}
