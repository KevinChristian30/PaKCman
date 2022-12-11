package utility;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundPlayer {

	public static MediaPlayer mediaPlayer = null;
	
	public static void playMusic() {
		
		if (mediaPlayer == null) {
			
			String path = "assets/audio/music.mp3";
			Media media = new Media(new File(path).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
			mediaPlayer.play();
			mediaPlayer.setVolume(0.5);
			
		}
		
	}
	
	public static void stopMusic() {
		
		mediaPlayer.stop();
		
	}
	
	public static void setVolume(double volume) {
		
		mediaPlayer.setVolume(volume);
		
	}
	
}
