package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import meta.ColorPalette;
import meta.FontPalette;
import model.Screen;
import model.models.Player;
import utility.SoundPlayer;

public class MenuScreenView extends Screen {

	Player player;
	BorderPane layoutContainer;
	Label usernameLabel;
	
	Button playButton, optionsButton, 
	leaderboardButton, logOutButton;
	VBox buttonContainer;

	public MenuScreenView(Player player) {
		
		super();
		this.player = player;
		
		initiateComponents();
		designLayout();
		setEventHandles();
		setScene();
		SoundPlayer.playMusic();
		
	}

	@Override
	protected void initiateComponents() {
		
		layoutContainer = new BorderPane();
		
		scene = new Scene(layoutContainer);
		palette = ColorPalette.getInstance();
		
		usernameLabel = new Label("Welcome, " + player.getPlayerName());
		playButton = new Button("Play");
		optionsButton = new Button("Options");
		leaderboardButton = new Button("Leaderboard");
		logOutButton = new Button("Log Out");
		buttonContainer = new VBox();
		
	}

	@Override
	protected void designLayout() {
		
		layoutContainer.setBackground(
			new Background(
			new BackgroundImage(
				new Image("file:./assets/menu-view/background.jpg"),
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER,
				new BackgroundSize(100, 0, true, false, true, true)
			)));
		
		usernameLabel.setFont(FontPalette.subtitleFont);
		usernameLabel.setPadding(new Insets(0, 0, 0, 0));
		usernameLabel.setStyle("-fx-font-weight: bold");
		usernameLabel.setTextFill(palette.colorPalette.get("Yellow"));
		layoutContainer.setCenter(usernameLabel);
		
		playButton.setBackground(null);
		optionsButton.setBackground(null);
		leaderboardButton.setBackground(null);
		logOutButton.setBackground(null);
		
		playButton.setTextFill(palette.colorPalette.get("Yellow"));
		optionsButton.setTextFill(palette.colorPalette.get("Yellow"));
		leaderboardButton.setTextFill(palette.colorPalette.get("Yellow"));
		logOutButton.setTextFill(palette.colorPalette.get("Yellow"));
		
		playButton.setStyle("-fx-font-weight: bold");
		optionsButton.setStyle("-fx-font-weight: bold");
		leaderboardButton.setStyle("-fx-font-weight: bold");
		logOutButton.setStyle("-fx-font-weight: bold");
		
		playButton.setFont(FontPalette.menuButtonFont);
		optionsButton.setFont(FontPalette.menuButtonFont);
		leaderboardButton.setFont(FontPalette.menuButtonFont);
		logOutButton.setFont(FontPalette.menuButtonFont);
		
		buttonContainer.getChildren().addAll(playButton, 
				leaderboardButton, optionsButton, logOutButton);
		buttonContainer.setAlignment(Pos.CENTER);
		BorderPane.setMargin(buttonContainer, new Insets(0, 0, 50, 0));
		buttonContainer.setBackground(
			new Background(
			new BackgroundFill(
				Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		buttonContainer.setEffect(
			new DropShadow(
				BlurType.values()[3], 
				palette.colorPalette.get("Blue"), 
				7, 3.0f, 2.0f, 2.0f));
		
		layoutContainer.setBottom(buttonContainer);
		
	}

	@Override
	protected void setEventHandles() {
		
		playButton.setOnMouseEntered(e -> {
			
			playButton.setBackground(null);
			playButton.setTextFill(palette.colorPalette.get("Green"));
			playButton.setStyle("-fx-font-weight: bold");
			playButton.setFont(FontPalette.menuButtonFont);
			
			
		});
		
		playButton.setOnMouseExited(e -> {
			
			playButton.setBackground(null);
			playButton.setTextFill(palette.colorPalette.get("Yellow"));
			playButton.setStyle("-fx-font-weight: bold");
			playButton.setFont(FontPalette.menuButtonFont);
			
		});
		
		playButton.setOnMouseClicked(e -> {
			
			
		});
		
		optionsButton.setOnMouseEntered(e -> {
			
			optionsButton.setBackground(null);
			optionsButton.setTextFill(palette.colorPalette.get("Green"));
			optionsButton.setStyle("-fx-font-weight: bold");
			optionsButton.setFont(FontPalette.menuButtonFont);
			
			
		});
		
		optionsButton.setOnMouseExited(e -> {
			
			optionsButton.setBackground(null);
			optionsButton.setTextFill(palette.colorPalette.get("Yellow"));
			optionsButton.setStyle("-fx-font-weight: bold");
			optionsButton.setFont(FontPalette.menuButtonFont);
			
		});
		
		optionsButton.setOnMouseClicked(e -> {
			
			
		});
		
		leaderboardButton.setOnMouseEntered(e -> {
			
			leaderboardButton.setBackground(null);
			leaderboardButton.setTextFill(palette.colorPalette.get("Green"));
			leaderboardButton.setStyle("-fx-font-weight: bold");
			leaderboardButton.setFont(FontPalette.menuButtonFont);
			
			
		});
		
		leaderboardButton.setOnMouseExited(e -> {
			
			leaderboardButton.setBackground(null);
			leaderboardButton.setTextFill(palette.colorPalette.get("Yellow"));
			leaderboardButton.setStyle("-fx-font-weight: bold");
			leaderboardButton.setFont(FontPalette.menuButtonFont);
			
		});
		
		leaderboardButton.setOnMouseClicked(e -> {
			
			
		});
		
		logOutButton.setOnMouseEntered(e -> {
			
			logOutButton.setBackground(null);
			logOutButton.setTextFill(palette.colorPalette.get("Green"));
			logOutButton.setStyle("-fx-font-weight: bold");
			logOutButton.setFont(FontPalette.menuButtonFont);
			
			
		});
		
		logOutButton.setOnMouseExited(e -> {
			
			logOutButton.setBackground(null);
			logOutButton.setTextFill(palette.colorPalette.get("Yellow"));
			logOutButton.setStyle("-fx-font-weight: bold");
			logOutButton.setFont(FontPalette.menuButtonFont);
			
		});
		
		logOutButton.setOnMouseClicked(e -> {
			
			
		});
		
		
	}
	
}
