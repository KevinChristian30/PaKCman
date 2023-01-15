package view;

import controller.MenuScreenController;
import controller.VictoryScreenController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
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
import meta.FontPalette;
import model.Screen;
import model.models.Player;

public class VictoryScreenView extends Screen{
	
	private Integer score;
	BorderPane layoutContainer;
	Label winLabel, scoreLabel, mainMenuButton;
	GridPane layout;
	Player player;
	
	public VictoryScreenView(Player player, int score) {
		
		this.score = score;
		this.player = player;
		
		initiateComponents();
		designLayout();
		setEventHandles();
		setScene();
		
		if (player.getPlayerHighScore() < score)
			Player.updateScore(player.getPlayerName(), score);
		
	}

	@Override
	protected void initiateComponents() {
		
		layoutContainer = new BorderPane();
		scene = new Scene(layoutContainer);
		winLabel = new Label("The End");
		scoreLabel = new Label("Your Score: " + this.score.toString());
		mainMenuButton = new Label("Main Menu");
		layout = new GridPane();
		
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
		layoutContainer.setCenter(layout);
		
		layout.setPrefSize(400, 400);
		layout.setBackground(
			new Background(
			new BackgroundFill(
				Color.BLACK,
				CornerRadii.EMPTY,
				Insets.EMPTY
			)));
		layout.setEffect(new DropShadow(
			BlurType.values()[2], Color.YELLOW, 7, 3, 2, 2
		));
		layout.setAlignment(Pos.CENTER);
		layout.setHgap(30);
		layout.setPadding(new Insets(30, 0, 30, 0));
		
		layout.add(winLabel, 0, 0);
		layout.add(scoreLabel, 0, 1);
		layout.add(mainMenuButton, 0, 2);
		
		winLabel.setFont(FontPalette.leaderboardTitleFont);
		winLabel.setTextFill(Color.YELLOW);
		winLabel.setStyle("-fx-font-weight: bold");
		
		scoreLabel.setFont(FontPalette.subtitleFont);
		scoreLabel.setTextFill(Color.YELLOW);
		scoreLabel.setStyle("-fx-font-weight: bold");
		
		mainMenuButton.setFont(FontPalette.subtitleFont);
		mainMenuButton.setTextFill(Color.YELLOW);
		mainMenuButton.setStyle("-fx-font-weight: bold");
		
	}

	@Override
	protected void setEventHandles() {
		
		mainMenuButton.setOnMouseEntered(e -> {
			
			mainMenuButton.setBackground(null);
			mainMenuButton.setTextFill(Color.GREEN);
			mainMenuButton.setStyle("-fx-font-weight: bold");
			mainMenuButton.setFont(FontPalette.menuButtonFont);
			
			
		});
		
		mainMenuButton.setOnMouseExited(e -> {
			
			mainMenuButton.setBackground(null);
			mainMenuButton.setTextFill(Color.YELLOWGREEN);
			mainMenuButton.setStyle("-fx-font-weight: bold");
			mainMenuButton.setFont(FontPalette.menuButtonFont);
			
		});
		
		mainMenuButton.setOnMouseClicked(e -> {
			
			VictoryScreenController.routeToMainMenuScreen(player);
			
		});
		
	}

}
