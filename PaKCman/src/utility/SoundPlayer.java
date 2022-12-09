package utility;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundPlayer {

	public static MediaPlayer mediaPlayer;
	
	public static void playMusic() {
		
		String path = SoundPlayer.
			class.getResourceAsStream("file/../../assets/audio.music.mp3")
			.toString();
		Media media = new Media(path);
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
		
	}
	
}
