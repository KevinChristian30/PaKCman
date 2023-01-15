package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.models.Player;
import view.LoginScreenView;
import view.MenuScreenView;
import view.PlayScreenView;
import view.VictoryScreenView;

public class Main extends Application{

	public static void main(String[] args) { launch(args); }
	
	private static Stage stage;
	private Scene scene;
	
	public static Stage getStage() {
		return stage;
	}
	
	private void initiateComponents() {
		
		stage = new Stage();
		scene = new Scene(new StackPane());
		
	}
	
	private void initiateStage() {
		
		stage.setScene(scene);
		
	}
	
	private void initiateMetaData() {
		
		stage.setWidth(1000);
		stage.setHeight(600);
		stage.setResizable(false);
		stage.setTitle("PaKCman");
		
		String path = "file:assets/logo/pacman-logo.png";
		Image icon = new Image(path);
		stage.getIcons().add(icon);
		
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		
		initiateComponents();
		initiateStage();
		initiateMetaData();
		stage.show();
//		new LoginScreenView();
		
		new PlayScreenView(new Player("Kevin", "abc", 100));
		
	}

}
