package view;

import controller.RegisterScreenController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import meta.ColorPalette;
import meta.FontPalette;
import model.Screen;

public class RegisterScreenView extends Screen{
	
	BorderPane layoutContainer;
	VBox layout;
	GridPane formContainer;
	
	Label registerScreenLabel, usernameLabel, passwordLabel, 
			loginLabel, errorLabel;
	TextField usernameTextField;
	PasswordField passwordPasswordField;
	Button registerButton, loginScreenButton;
	HBox loginContainer;
	
	public RegisterScreenView() {
		
		initiateComponents();
		designLayout();
		setEventHandles();
		setScene();
		
	}
	
	@Override
	protected void initiateComponents() {
		
		layoutContainer = new BorderPane();
		layout = new VBox();
		formContainer = new GridPane();
		registerScreenLabel = new Label("Register");
		usernameLabel = new Label("Username");
		passwordLabel = new Label("Password");
		loginLabel = new Label("Already have an account? Login ");
		errorLabel = new Label("");
		usernameTextField = new TextField();
		passwordPasswordField = new PasswordField();
		registerButton = new Button("Register");
		loginScreenButton = new Button("Here");
		loginContainer = new HBox();
		
		scene = new Scene(layoutContainer);
		palette = ColorPalette.getInstance();
		
	}

	@Override
	protected void designLayout() {
		
		layoutContainer.setCenter(layout);
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
		layout.getChildren().add(registerScreenLabel);
		layout.setAlignment(Pos.CENTER);
		
		registerScreenLabel.setFont(FontPalette.titleFont);
		registerScreenLabel.setTextFill(
			palette.colorPalette.get("Yellow"));
		
		usernameLabel.setFont(FontPalette.subtitleFont);
		usernameLabel.setTextFill(
				palette.colorPalette.get("Yellow"));
		usernameLabel.setStyle("-fx-font-weight: bold");
		
		passwordLabel.setFont(FontPalette.subtitleFont);
		passwordLabel.setTextFill(
				palette.colorPalette.get("Yellow"));
		passwordLabel.setStyle("-fx-font-weight: bold");
		
		usernameLabel.setFont(FontPalette.subtitleFont);
		usernameLabel.setTextFill(palette.colorPalette.get("Yellow"));
		passwordLabel.setFont(FontPalette.subtitleFont);
		passwordLabel.setTextFill(palette.colorPalette.get("Yellow"));
		usernameTextField.setPrefSize(250, 30);
		usernameTextField.setBorder(
			new Border(
			new BorderStroke(
				palette.colorPalette.get("Yellow"),
				BorderStrokeStyle.SOLID,
				new CornerRadii(3),
				new BorderWidths(2))));
		usernameTextField.setBackground(null);
		usernameTextField.setStyle("-fx-text-fill: rgb(255, 255, 0)");
		passwordPasswordField.setPrefSize(250, 30);
		passwordPasswordField.setBorder(
				new Border(
				new BorderStroke(
					palette.colorPalette.get("Yellow"),
					BorderStrokeStyle.SOLID,
					new CornerRadii(3),
					new BorderWidths(2))));
		passwordPasswordField.setBackground(null);
		passwordPasswordField.setStyle("-fx-text-fill: rgb(255, 255, 0)");
		
		registerButton.setPrefSize(250, 30);
		registerButton.setBackground(
				new Background(
				new BackgroundFill(
					Color.BLACK,
					new CornerRadii(3),
					Insets.EMPTY)));
		registerButton.setTextFill(palette.colorPalette.get("Yellow"));
		registerButton.setFont(FontPalette.subtitleFont);
		registerButton.setBorder(
				new Border(
				new BorderStroke(
					palette.colorPalette.get("Yellow"),
					BorderStrokeStyle.SOLID,
					new CornerRadii(3),
					new BorderWidths(2))));
		
		loginLabel.setFont(FontPalette.subtitleFont);
		loginLabel.setTextFill(
				palette.colorPalette.get("Yellow"));
		
		errorLabel.setTextFill(Color.RED);
		
		formContainer.add(usernameLabel, 0, 0);
		formContainer.add(usernameTextField, 1, 0);
		formContainer.add(passwordLabel, 0, 1);
		formContainer.add(passwordPasswordField, 1, 1);
		formContainer.add(registerButton, 1, 2);
		formContainer.add(errorLabel, 1, 3);
		formContainer.setAlignment(Pos.CENTER);
		formContainer.setHgap(10);
		formContainer.setVgap(10);
		layout.getChildren().add(formContainer);
		
		VBox.setMargin(registerScreenLabel, new Insets(0, 0, 50, 0));
		VBox.setMargin(loginContainer, new Insets(50, 0, 0, 0));
		
		loginScreenButton.setFont(FontPalette.subtitleFont);
		loginScreenButton.setPadding(new Insets(0));
		
		loginScreenButton.setBackground(
				new Background(
				new BackgroundFill(
					Color.BLACK,
					new CornerRadii(3),
					Insets.EMPTY)));
		loginScreenButton.setTextFill(palette.colorPalette.get("Red"));
		
		loginContainer.getChildren().addAll(loginLabel, loginScreenButton);
		layout.getChildren().add(loginContainer);
		loginContainer.setAlignment(Pos.CENTER);
		
	}

	@Override
	protected void setEventHandles() {
		
		loginScreenButton.setOnMouseEntered(e -> {
			
			loginScreenButton.setBackground(
				new Background(
				new BackgroundFill(
					palette.colorPalette.get("Primary-Dark"), 
					CornerRadii.EMPTY, 
					Insets.EMPTY)));
			loginScreenButton.setTextFill(palette.colorPalette.get("Green"));
			
		});
		
		loginScreenButton.setOnMouseExited(e -> {
			
			loginScreenButton.setBackground(
					new Background(
					new BackgroundFill(
						Color.BLACK,
						new CornerRadii(3),
						Insets.EMPTY)));
			loginScreenButton.setTextFill(palette.colorPalette.get("Red"));
			
		});
		
		loginScreenButton.setOnMouseClicked(e -> {
			
			RegisterScreenController.routeToLoginScreen();
			
		});
		
		registerButton.setOnMouseEntered(e -> {
			
			registerButton.setBackground(
					new Background(
					new BackgroundFill(
						palette.colorPalette.get("Yellow"),
						new CornerRadii(3),
						Insets.EMPTY)));
			registerButton.setTextFill(Color.BLACK);
			
		});
		
		registerButton.setOnMouseExited(e -> {
			
			registerButton.setBackground(
					new Background(
					new BackgroundFill(
						Color.BLACK,
						new CornerRadii(3),
						Insets.EMPTY)));
			registerButton.setTextFill(palette.colorPalette.get("Yellow"));
			
		});
		
		registerButton.setOnMouseClicked(e -> {
			
			String username = usernameTextField.getText();
			String password = passwordPasswordField.getText();
			
			if (username.length() < 5) {
				
				errorLabel.setText("Username must be at "
						+ "least 5 characters long");
				
			} else if (password.length() < 8) {
				
				errorLabel.setText("Password must be at "
						+ "least 8 characters long");
				
			} else {
				
				errorLabel.setText("");
				if (RegisterScreenController.attemptRegister
					(username, password)) new LoginScreenView();
				else {
					errorLabel.setText("Username Already Exist");
				}
				
			}
			
		});
		
	}
	
}
