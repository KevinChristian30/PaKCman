package meta;

import java.util.HashMap;

import javafx.scene.paint.Color;

public class ColorPalette {

	public HashMap<String, Color> colorPalette;
	private static ColorPalette instance = null;
	
	private ColorPalette() {
		
		colorPalette = new HashMap<>();
		
		colorPalette.put("Primary-Dark", Color.rgb(4, 108, 228));
		colorPalette.put("Primary-Light", Color.rgb(124, 180, 239));
		colorPalette.put("Secondary", Color.WHITE);
		
	}
	
	public static synchronized ColorPalette getInstance() {
		
		if (instance == null) {
			instance = new ColorPalette();
		}
		return instance;
		
	}
	
}
