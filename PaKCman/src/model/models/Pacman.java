package model.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import model.interfaces.IMovable;

public class Pacman extends GameObject implements IMovable{
	
	public final int SPEED = 5;
	public final int WIDTH = 25;
	public int positionX, positionY;
	
	public KeyCode currentKey;
	
	public Pacman(int positionX, int positionY) {
		
		this.positionX = positionX;
		this.positionY = positionY;
		
	}
	
	@Override
	public void render(GraphicsContext GC){
		
		GC.setFill(Color.YELLOW);
		GC.fillArc(positionX, positionY, WIDTH, WIDTH, 
				0, Math.toDegrees(2 * Math.PI), ArcType.ROUND);
		
	}

	@Override
	public void moveUp() {
		positionY -= SPEED;
	}

	@Override
	public void moveDown() {
		positionY += SPEED;
	}

	@Override
	public void moveLeft() {
		positionX -= SPEED;
	}

	@Override
	public void moveRight() {
		positionX += SPEED;
	}
	
	public void change() {
		
		if (currentKey == KeyCode.W || currentKey == KeyCode.UP) {
			
			moveUp();
			
		} else if (currentKey == KeyCode.A || currentKey == KeyCode.LEFT) {
			
			moveLeft();
			
		} else if (currentKey == KeyCode.S || currentKey == KeyCode.DOWN) {
			
			moveDown();
			
		} else if (currentKey == KeyCode.D || currentKey == KeyCode.RIGHT) {
			
			moveRight();
			
		}
		
		
		
	}

}
