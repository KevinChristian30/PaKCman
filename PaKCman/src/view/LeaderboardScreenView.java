package view;

import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;

import java.util.ArrayList;

import controller.LeaderboardScreenController;
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
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import meta.ColorPalette;
import meta.FontPalette;
import model.Screen;
import model.models.Player;

public class LeaderboardScreenView extends Screen{

	ArrayList<Player> players;
	Player currentPlayer;
	
	BorderPane layoutContainer;
	GridPane layout;
	
	Label[][] labels = new Label[6][3];
	Label leaderboardScreenTitle;
	Label backButton;
	
	public LeaderboardScreenView(ArrayList<Player> players, Player currentPlayer) {

		this.players = players;
		this.currentPlayer = currentPlayer;
		
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
		
		backButton = new Label("Back");
		leaderboardScreenTitle = new Label("Highscores");
		
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
		layout.setPadding(new Insets(30, 0, 30, 0));
		
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 2; j++) {
				labels[i][j].setFont(FontPalette.leaderboardFont);
				labels[i][j].setTextFill(
						palette.colorPalette.get("Yellow"));
				labels[i][j].setStyle("-fx-font-weight: bold");
			}
		
		leaderboardScreenTitle.setFont(FontPalette.leaderboardTitleFont);
		leaderboardScreenTitle.setTextFill(
				palette.colorPalette.get("Yellow"));
		leaderboardScreenTitle.setStyle("-fx-font-weight: bold");
		BorderPane.setAlignment(leaderboardScreenTitle, Pos.CENTER);
		leaderboardScreenTitle.setBackground(
				new Background(
				new BackgroundFill(
					Color.BLACK,
					CornerRadii.EMPTY,
					Insets.EMPTY
				)));
		leaderboardScreenTitle.setBorder(
			new Border(
			new BorderStroke(Color.YELLOW, Color.YELLOW, 
							 Color.YELLOW,Color.YELLOW,
							 BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
							 BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
							 new CornerRadii(5), 
							 new BorderWidths(5), 
							 Insets.EMPTY)));
		
		backButton.setFont(FontPalette.leaderboardFont);
		backButton.setTextFill(
				palette.colorPalette.get("Red"));
		backButton.setStyle("-fx-font-weight: bold");
		BorderPane.setAlignment(backButton, Pos.CENTER);
		backButton.setBackground(
				new Background(
				new BackgroundFill(
					Color.BLACK,
					CornerRadii.EMPTY,
					Insets.EMPTY
				)));
		backButton.setBorder(
			new Border(
			new BorderStroke(Color.YELLOW, Color.YELLOW, 
							 Color.YELLOW,Color.YELLOW,
							 BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
							 BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
							 new CornerRadii(5), 
							 new BorderWidths(5), 
							 Insets.EMPTY)));
		
		layoutContainer.setCenter(layout);
		layoutContainer.setBottom(backButton);
		layoutContainer.setTop(leaderboardScreenTitle);
		
	}

	@Override
	protected void setEventHandles() {
		
		backButton.setOnMouseEntered(e -> {
			
			backButton.setTextFill(
					palette.colorPalette.get("Green"));
			
		});
		
		backButton.setOnMouseExited(e -> {
			
			backButton.setTextFill(
					palette.colorPalette.get("Red"));
			
		});
		
		backButton.setOnMouseClicked(e -> {
			
			LeaderboardScreenController.routeToMenuScreen(currentPlayer);
			
		});
		
	}

}
;