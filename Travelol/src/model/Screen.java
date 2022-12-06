package model;

import javafx.scene.Scene;
import main.Main;
import meta.ColorPalette;

public abstract class Screen {

	protected Scene scene;
	protected ColorPalette palette;
	
	protected abstract void initiateComponents();
	
	protected abstract void designLayout();
	
	protected abstract void setEventHandles();
	
	public void setScene() {
		
		Main.getStage().setScene(scene);
		
	}
	
}
