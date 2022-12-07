package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import meta.ColorPalette;
import model.Screen;

public class RegisterScreenView extends Screen{
	
	BorderPane layoutContainer;
	VBox layout;
	GridPane formContainer;
	
	Label registerScreenLabel, usernameLabel, passwordLabel, loginLabel;
	TextField usernameTextField;
	PasswordField passwordPasswordField;
	Button registerButton;
	
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
		usernameTextField = new TextField();
		passwordPasswordField = new PasswordField();
		registerButton = new Button("Register");
		
		scene = new Scene(layoutContainer);
		palette = ColorPalette.getInstance();
		
	}

	@Override
	protected void designLayout() {
		
		layoutContainer.setCenter(layout);
		layoutContainer.setBackground(
				new Background(
				new BackgroundFill(Color.BLACK, 
					CornerRadii.EMPTY, 
					new Insets(0))));
		layout.getChildren().add(registerScreenLabel);
		layout.setAlignment(Pos.CENTER);
//		layout.setPrefSize(400, 400);
//		layout.setBorder(
//				new Border(
//				new BorderStroke(
//					palette.colorPalette.get("Yellow"),
//					BorderStrokeStyle.SOLID,
//					new CornerRadii(3),
//					new BorderWidths(2))));
		
		formContainer.add(usernameLabel, 0, 0);
		formContainer.add(usernameTextField, 1, 0);
		formContainer.add(passwordLabel, 0, 1);
		formContainer.add(passwordPasswordField, 1, 1);
		formContainer.add(registerButton, 1, 2);
		formContainer.setAlignment(Pos.CENTER);
		layout.getChildren().add(formContainer);
		
		layout.getChildren().add(loginLabel);
		
	}

	@Override
	protected void setEventHandles() {
		
	}
	
}
