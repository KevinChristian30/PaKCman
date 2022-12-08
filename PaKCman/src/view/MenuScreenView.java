package view;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import meta.ColorPalette;
import model.Screen;
import model.models.Player;

public class MenuScreenView extends Screen {

	Player player;

	public MenuScreenView(Player player) {
		
		super();
		this.player = player;
		
		initiateComponents();
		designLayout();
		setEventHandles();
		setScene();
		
	}

	@Override
	protected void initiateComponents() {
		
		scene = new Scene(new StackPane());
		palette = ColorPalette.getInstance();
		
	}

	@Override
	protected void designLayout() {
		
	}

	@Override
	protected void setEventHandles() {
		
	}
	
}
