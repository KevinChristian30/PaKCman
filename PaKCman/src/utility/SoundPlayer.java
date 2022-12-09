package utility;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundPlayer {

	public static MediaPlayer mediaPlayer;
	
	public static void playMusic() {
		
		String path = "assets/audio/music.mp3";
		Media media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
		
	}
	
}
