package model.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import main.Main;
import model.interfaces.IMovable;

public class Pacman extends GameObject implements IMovable{
	
	public final int SPEED = 5;
	public final int WIDTH = 25;
	public int positionX, positionY;
	
	boolean collide;
	
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
	
	private boolean isColliding() {
		
		for (Wall e : GameMap.walls) {
			if(positionX < e.positionX + e.width &&
				positionX + WIDTH > e.positionX &&
				positionY < e.positionY + e.width &&
				positionY + WIDTH > e.positionY)
				return true;
		}
		return false;
		
	}
	
	public void change() {
		
		collide = false;
		if (currentKey == KeyCode.W || currentKey == KeyCode.UP) {
			
			if (!isColliding()) moveUp();
			
		} else if (currentKey == KeyCode.A || currentKey == KeyCode.LEFT) {
			
			if (!isColliding()) moveLeft();
			
		} else if (currentKey == KeyCode.S || currentKey == KeyCode.DOWN) {
			
			if (!isColliding()) moveDown();
			
		} else if (currentKey == KeyCode.D || currentKey == KeyCode.RIGHT) {
			
			if (!isColliding()) moveRight();
			
		}
		
		if (positionX >= Main.getStage().getWidth()) {
			positionX = 0;
		} else if (positionX < 0) {
			positionX = (int) Main.getStage().getWidth();
		}
		
	}

}
