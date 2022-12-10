package view;

import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import meta.ColorPalette;
import meta.FontPalette;
import model.Screen;
import model.models.Player;

public class LeaderboardScreenView extends Screen{

	ArrayList<Player> players;
	
	BorderPane layoutContainer;
	GridPane layout;
	
	Label[][] labels = new Label[6][3];
	
	
	public LeaderboardScreenView(ArrayList<Player> players) {

		this.players = players;
		
		initiateComponents();
		designLayout();
		setEventHandles();
		setScene();
		
	}

	@Override
	protected void initiateComponents() {
		
		layout = new GridPane();
		layoutContainer = new BorderPane();
		
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 2; j++)
				labels[i][j] = new Label("");
		
		scene = new Scene(layoutContainer);
		palette = ColorPalette.getInstance();
		
	}
	
	private void setGridLabels() {
		
		for (int i = 0; i < 5; i++) {
			labels[i][0].setText(players.get(i).getPlayerName());
			labels[i][1].setText(Integer.toString(players.get(i).getPlayerHighScore()));
		}
		
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 2; j++)
				layout.add(labels[i][j], j, i);
		
	}

	@Override
	protected void designLayout() {
		
		layoutContainer.setPadding(new Insets(100, 200, 100, 200));
		layoutContainer.setBackground(
				new Background(
				new BackgroundImage(
					new Image("file:./assets/register-view/gameplay.jpg"),
					BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT,
					BackgroundPosition.CENTER,
					new BackgroundSize(100, 0, true, false, true, true)
				)));
		
		
		setGridLabels();
		
		layout.setPrefSize(400, 400);
		layout.setBackground(
			new Background(
			new BackgroundFill(
				Color.BLACK,
				CornerRadii.EMPTY,
				Insets.EMPTY
			)));
		layout.setEffect(
				new DropShadow(
					BlurType.values()[2], 
					palette.colorPalette.get("Yellow"), 
					7, 3.0f, 2.0f, 2.0f));
		layout.setAlignment(Pos.CENTER);
		layout.setHgap(30);
		
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 2; j++) {
				labels[i][j].setFont(FontPalette.leaderboardFont);
				labels[i][j].setTextFill(
						palette.colorPalette.get("Yellow"));
				labels[i][j].setStyle("-fx-font-weight: bold");
			}
		
		layoutContainer.setCenter(layout);
		
	}

	@Override
	protected void setEventHandles() {
		
	}

}
