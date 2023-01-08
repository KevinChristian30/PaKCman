package model.models;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import meta.ColorPalette;

public class GameMap extends GameObject{
	
	public static ArrayList<Wall> walls = new ArrayList<>();

	private final int WIDTH = 30;
	
	// 1000 / 25 = 40
	// 750 / 25 = 30
	
	public static final String[] map = {
		"################################",
		"#                              #",
		"# ########## ###### ########## #",
		"# #                          # #",
		"# # ##### #### ## #### ##### # #",
		"#         #          #         #",
		"# ## #### # # #### # # #### ## #",
		"# ## #### # # #  # # # #### ## #",
		"#                              #",
		"# #### ###### #### ###### #### #",
		"#                              #",
		"# ## #### # # #  # # # #### ## #",
		"# ## #### # # #### # # #### ## #",
		"#         #          #         #",
		"# # ##### ### ### #### ##### # #",
		"# #                          # #",
		"# ########## ###### ########## #",
		"#                              #",
		"################################"
	};
	
	public GameMap(){
		
		for (int i = 0; i < 19; i++)
			for (int j = 0; j < 32; j++) {
				if (map[i].charAt(j) == '#') {
					walls.add(new Wall(j * WIDTH, i * WIDTH));
				}
			}		
		
	}
	
	@Override
	public void render(GraphicsContext GC) {
		
		walls.forEach(e -> {
			
			GC.setFill(ColorPalette.getInstance().colorPalette.get("Blue"));
			GC.fillRect(e.positionX, e.positionY, WIDTH, WIDTH);
			
		});
		
	}

}
