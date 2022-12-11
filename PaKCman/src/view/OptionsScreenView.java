package view;

import controller.OptionsScreenController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import meta.ColorPalette;
import meta.FontPalette;
import model.Screen;
import model.models.Player;
import utility.SoundPlayer;

public class OptionsScreenView extends Screen{

	Player player;
	
	BorderPane layoutContainer, layout;
	Label backButton, saveButton;
	Slider volumeWheel;
	GridPane buttonContainer;
	VBox optionsContainer;
	Label optionScreenTitle, volumeTitle;

	public OptionsScreenView(Player player) {
		
		super();
		this.player = player;
		
		initiateComponents();
		designLayout();
		setEventHandles();
		setScene();
		
	}

	@Override
	protected void initiateComponents() {
		
		layoutContainer = new BorderPane();
		layout = new BorderPane();
		backButton = new Label("Back");
		saveButton = new Label("Save");
		volumeWheel = new Slider(0, 1, 0.5);
		buttonContainer = new GridPane();
		
		optionScreenTitle = new Label("Options");
		volumeTitle = new Label("Volume");
		
		optionsContainer = new VBox();
		
		scene = new Scene(layoutContainer);
		palette = ColorPalette.getInstance();
		
	}

	@Override
	protected void designLayout() {
		
		scene.getStylesheets().add("file:./styles/volume-wheel.css");
		
		layoutContainer.setBackground(
				new Background(
				new BackgroundFill(
					Color.BLACK,
					CornerRadii.EMPTY,
					Insets.EMPTY)));
		
		layoutContainer.setCenter(layout);
		
		volumeTitle.setFont(FontPalette.leaderboardFont);
		volumeTitle.setPadding(new Insets(0, 0, 0, 0));
		volumeTitle.setStyle("-fx-font-weight: bold");
		volumeTitle.setTextFill(palette.colorPalette.get("Yellow"));
		BorderPane.setAlignment(optionScreenTitle, Pos.CENTER);
		VBox.setMargin(volumeWheel, new Insets(0, 200, 0, 200));
		optionsContainer.getChildren().add(volumeTitle);
		optionsContainer.getChildren().add(volumeWheel);
		optionsContainer.setAlignment(Pos.CENTER);
		
		layout.setCenter(optionsContainer);

		optionScreenTitle.setFont(FontPalette.titleFont);
		optionScreenTitle.setPadding(new Insets(0, 0, 0, 0));
		optionScreenTitle.setStyle("-fx-font-weight: bold");
		optionScreenTitle.setTextFill(palette.colorPalette.get("Yellow"));
		BorderPane.setAlignment(optionScreenTitle, Pos.CENTER);
		optionScreenTitle.setPadding(new Insets(50, 0, 0, 0));
		
		layout.setTop(optionScreenTitle);
		
		backButton.setFont(FontPalette.leaderboardFont);
		backButton.setPadding(new Insets(0, 0, 0, 0));
		backButton.setStyle("-fx-font-weight: bold");
		backButton.setTextFill(palette.colorPalette.get("Yellow"));
		
		saveButton.setFont(FontPalette.leaderboardFont);
		saveButton.setPadding(new Insets(0, 0, 0, 0));
		saveButton.setStyle("-fx-font-weight: bold");
		saveButton.setTextFill(palette.colorPalette.get("Yellow"));
		
		buttonContainer.add(backButton, 0, 0);
		buttonContainer.add(saveButton, 1, 0);
		
		layout.setBottom(buttonContainer);
		buttonContainer.setAlignment(Pos.CENTER);
		buttonContainer.setPadding(new Insets(0, 0, 50, 0));
		buttonContainer.setHgap(50);
		
	}

	@Override
	protected void setEventHandles() {
		
		backButton.setOnMouseEntered(e -> {
			
			backButton.setTextFill(palette.colorPalette.get("Green"));
			
		});
		
		backButton.setOnMouseExited(e -> {
			
			backButton.setTextFill(palette.colorPalette.get("Yellow"));
			
		});
		
		backButton.setOnMouseClicked(e -> {
			
			OptionsScreenController.routeToMenuSreen(player);
			
		});
		
		saveButton.setOnMouseEntered(e -> {
			
			saveButton.setTextFill(palette.colorPalette.get("Green"));
			
		});
		
		saveButton.setOnMouseExited(e -> {
			
			saveButton.setTextFill(palette.colorPalette.get("Yellow"));
			
		});
		
		saveButton.setOnMouseClicked(e -> {
			
			SoundPlayer.setVolume(volumeWheel.getValue());
			
		});
		
	}
	
}
