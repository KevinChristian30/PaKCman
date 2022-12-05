package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import meta.ColorPalette;
import model.Screen;

public class LoginScreenView extends Screen{

	BorderPane layoutContainer;
	GridPane layout;
		
	VBox left, right;
	Label loginFormLabel, usernameLabel, passwordLabel;
	TextField usernameTextField;
	PasswordField passwordPasswordField;
	GridPane formContainer;
	Button loginButton;
	
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
		
	}

	@Override
	protected void designLayout() {
		
		layoutContainer.setCenter(layout);

		layout.add(left, 0, 0);
		layout.add(right, 1, 0);
		
 		loginFormLabel.setFont(new Font(30));
		right.getChildren().add(loginFormLabel);
		formContainer.add(usernameLabel, 0, 0);
		formContainer.add(usernameTextField, 1, 0);
		formContainer.add(passwordLabel, 0, 1);
		formContainer.add(passwordPasswordField, 1, 1);
		right.getChildren().add(formContainer);
		right.getChildren().add(loginButton);
		
	}
	
}
