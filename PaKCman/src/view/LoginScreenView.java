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
		setEventHandles();
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
		loginFormLabel = new Label("PaKCman!");
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
			new BackgroundFill(Color.BLACK, 
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
				new Image("file:./assets/login-view/gameplay-screen.png"),
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT
			)));
		left.setEffect(
			new DropShadow(
				BlurType.values()[2], 
				palette.colorPalette.get("Dark-Blue"), 7, 3.0f, 2.0f, 2.0f));
		
		right.setPrefSize(dimension, dimension);
		right.setBackground(
			new Background(
			new BackgroundFill(Color.BLACK, 
				CornerRadii.EMPTY, 
				new Insets(0))));
		right.setEffect(
				new DropShadow(
					BlurType.values()[2], 
					palette.colorPalette.get("Dark-Blue"), 7, 3.0f, 2.0f, 2.0f));
		
 		loginFormLabel.setFont(FontPalette.titleFont);
 		loginFormLabel.setPadding(new Insets(20, 0, 70, 0));
 		loginFormLabel.setTextFill(palette.colorPalette.get("Yellow"));
		right.getChildren().add(loginFormLabel);
		
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
		
		formContainer.add(usernameLabel, 0, 0);
		formContainer.add(usernameTextField, 1, 0);
		formContainer.add(passwordLabel, 0, 1);
		formContainer.add(passwordPasswordField, 1, 1);
		formContainer.setPadding(new Insets(0, 0, 50, 33));
		formContainer.setHgap(10);
		formContainer.setVgap(10);
		right.getChildren().add(formContainer);
		
		loginButton.setPrefSize(250, 30);
		loginButton.setBackground(
				new Background(
				new BackgroundFill(
					Color.BLACK,
					new CornerRadii(3),
					Insets.EMPTY)));
		loginButton.setTextFill(palette.colorPalette.get("Yellow"));
		loginButton.setFont(FontPalette.subtitleFont);
		loginButton.setBorder(
				new Border(
				new BorderStroke(
					palette.colorPalette.get("Yellow"),
					BorderStrokeStyle.SOLID,
					new CornerRadii(3),
					new BorderWidths(2))));
		formContainer.add(loginButton, 1, 2);
		
		registerLabel.setTextFill(palette.colorPalette.get("Red"));
		
		registerContainer.getChildren().add(registerLabel);
		registerContainer.getChildren().add(registerButton);
		registerContainer.setPadding(new Insets(0, 0, 0, 33));
		right.getChildren().add(registerContainer);
		
		registerButton.setBackground(null);
		registerButton.setPadding(new Insets(0));
		registerButton.setTextFill(palette.colorPalette.get("Yellow"));
		registerButton.setStyle("-fx-font-weight: bold");
		right.setAlignment(Pos.CENTER);
		
	}
	
	protected void setEventHandles() {
		
		registerButton.setOnMouseEntered(e -> {
			
			registerButton.setBackground(
				new Background(
				new BackgroundFill(
					palette.colorPalette.get("Primary-Dark"), 
					CornerRadii.EMPTY, 
					Insets.EMPTY)));
			registerButton.setTextFill(palette.colorPalette.get("Green"));
			
		});
		
		registerButton.setOnMouseExited(e -> {
			
			loginButton.setBackground(
					new Background(
					new BackgroundFill(
						palette.colorPalette.get("Yellow"),
						new CornerRadii(3),
						Insets.EMPTY)));
			loginButton.setTextFill(Color.BLACK);
			registerButton.setTextFill(palette.colorPalette.get("Yellow"));
			
		});
		
		loginButton.setOnMouseEntered(e -> {
			
			loginButton.setBackground(
					new Background(
					new BackgroundFill(
						palette.colorPalette.get("Yellow"),
						new CornerRadii(3),
						Insets.EMPTY)));
			loginButton.setTextFill(Color.BLACK);
			
		});
		
		loginButton.setOnMouseExited(e -> {
			
			loginButton.setBackground(
					new Background(
					new BackgroundFill(
						Color.BLACK,
						new CornerRadii(3),
						Insets.EMPTY)));
			loginButton.setTextFill(palette.colorPalette.get("Yellow"));
			
		});
		
	}
	
}
;