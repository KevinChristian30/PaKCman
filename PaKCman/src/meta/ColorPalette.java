package meta;

import java.util.HashMap;

import javafx.scene.paint.Color;

public class ColorPalette {

	public HashMap<String, Color> colorPalette;
	private static ColorPalette instance = null;
	
	private ColorPalette() {
		
		colorPalette = new HashMap<>();
		
		colorPalette.put("Yellow", Color.rgb(255, 255, 0));
		colorPalette.put("Dark-Blue", Color.rgb(25, 25, 166));
		colorPalette.put("Blue", Color.rgb(33, 33, 222));
		colorPalette.put("Beige", Color.rgb(222, 161, 133));
		colorPalette.put("Red", Color.rgb(253, 0, 0));
		colorPalette.put("Green", Color.rgb(0, 255, 0));
		
	}
	
	public static synchronized ColorPalette getInstance() {
		
		if (instance == null) {
			instance = new ColorPalette();
		}
		return instance;
		
	}
	
}
