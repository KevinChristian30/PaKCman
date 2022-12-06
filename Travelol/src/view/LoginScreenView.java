package view;

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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import meta.ColorPalette;
import meta.FontPalette;
import model.Screen;

public class LoginScreenView extends Screen{

	BorderPane layoutContainer;
	GridPane layout;
		
	VBox left, right;
	Label loginFormLabel, usernameLabel, passwordLabel, registerLabel;
	TextField usernameTextField;
	PasswordField passwordPasswordField;
	GridPane formContainer;
	Button loginButton, registerButton;
	HBox registerContainer;
	
	public LoginScreenView() {
		
		initiateComponents();
		designLayout();
		setScene();
		
	}

	@Override
	protected void initiateComponents() {
		
		layoutContainer = new BorderPane();
		scene = new Scene(layoutContainer);
		palette = ColorPalette.getInstance();

		layout = new GridPane();

		left = new VBox();

		right = new VBox();
		loginFormLabel = new Label("Login");
		usernameLabel = new Label("Username");
		passwordLabel = new Label("Password");
		usernameTextField = new TextField();
		passwordPasswordField = new PasswordField();
		formContainer = new GridPane();
		loginButton = new Button("Login");
		registerLabel = new Label("Don't have an account? Register ");
		registerButton = new Button("Here");
		registerContainer = new HBox();
		
	}

	@Override
	protected void designLayout() {
		
		layoutContainer.setCenter(layout);
		layoutContainer.setBackground(
			new Background(
			new BackgroundFill(palette.colorPalette.get("Primary-Light"), 
				CornerRadii.EMPTY, 
				new Insets(0))));
		
		layout.setAlignment(Pos.CENTER);
		layout.add(left, 0, 0);
		layout.add(right, 1, 0);

		int dimension = 400;
		
		left.setPrefSize(dimension, dimension);
		left.setBackground(
			new Background(
			new BackgroundImage(
				new Image("file:./assets/login-view/vacation-destination.jpg"),
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT
			)));
		left.setEffect(
			new DropShadow(
				BlurType.values()[2], 
				Color.BLACK, 5, 3.0f, 2.0f, 2.0f));
		
		right.setPrefSize(dimension, dimension);
		right.setBackground(
			new Background(
			new BackgroundFill(palette.colorPalette.get("Secondary"), 
				CornerRadii.EMPTY, 
				new Insets(0))));
		right.setEffect(
				new DropShadow(
					BlurType.values()[2], 
					Color.BLACK, 5, 3.0f, 2.0f, 2.0f));
		
 		loginFormLabel.setFont(FontPalette.titleFont);
 		loginFormLabel.setPadding(new Insets(-70, 0, 100, 0));
		right.getChildren().add(loginFormLabel);
		
		usernameLabel.setFont(FontPalette.subtitleFont);
		passwordLabel.setFont(FontPalette.subtitleFont);
		usernameTextField.setPrefSize(250, 20);
		passwordPasswordField.setPrefSize(250, 20);
		
		formContainer.add(usernameLabel, 0, 0);
		formContainer.add(usernameTextField, 1, 0);
		formContainer.add(passwordLabel, 0, 1);
		formContainer.add(passwordPasswordField, 1, 1);
		formContainer.setPadding(new Insets(0, 0, 0, 33));
		formContainer.setHgap(10);
		formContainer.setVgap(5);
		right.getChildren().add(formContainer);
		
		VBox.setMargin(loginButton, new Insets(30, 0, 0, 0));
		loginButton.setPrefSize(150, 20);
		right.getChildren().add(loginButton);
		
		registerContainer.getChildren().add(registerLabel);
		registerContainer.getChildren().add(registerButton);
		right.getChildren().add(registerContainer);
		
		right.setAlignment(Pos.CENTER);
		
	}
	
}
