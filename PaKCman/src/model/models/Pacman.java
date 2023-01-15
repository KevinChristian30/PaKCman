package model.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import main.Main;
import model.interfaces.IMovable;
import view.PlayScreenView;

public class Pacman extends GameObject implements IMovable{
	
	public int SPEEDX = 5;
	public int SPEEDY = 5;
	public final int WIDTH = 20;
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
		positionY -= SPEEDY;
	}

	@Override
	public void moveDown() {
		positionY += SPEEDY;
	}

	@Override
	public void moveLeft() {
		positionX -= SPEEDX;
	}

	@Override
	public void moveRight() {
		positionX += SPEEDX;
	}
	
	private boolean collideWithWall() {
		
		for (Wall e : GameMap.walls) {
			if(positionX - SPEEDX < e.positionX + e.width &&
				positionX + WIDTH + SPEEDX > e.positionX &&
				positionY - SPEEDY < e.positionY + e.width &&
				positionY + WIDTH + SPEEDY > e.positionY) {
				return true;
			}
		}
		return false;
		
	}
	
	private void collideWithFood() {
		
		for (Food e : GameMap.foods) {
			if(positionX <= e.getPositionX() + Food.FOODWIDTH &&
				positionX + WIDTH >= e.getPositionX() &&
				positionY <= e.getPositionY() + Food.FOODWIDTH &&
				positionY + WIDTH >= e.getPositionY()) {
				GameMap.foods.remove(e);
				PlayScreenView.score += 100;
				break;
			}
		}
		
	}
	
	public void change() {
		
		if (currentKey == KeyCode.W || currentKey == KeyCode.UP) {
			
			if (collideWithWall()) {
				positionY = positionY + SPEEDY;
				currentKey = null;
			} else {
				moveUp();
			}
			
			
		} else if (currentKey == KeyCode.A || currentKey == KeyCode.LEFT) {
			
			if (collideWithWall()) {
				positionX = positionX + SPEEDX;
				currentKey = null;
			} else {
				moveLeft();
			}
			
		} else if (currentKey == KeyCode.S || currentKey == KeyCode.DOWN) {
			
			if (collideWithWall()) {
				positionY = positionY - SPEEDY;
				currentKey = null;
			} else {
				moveDown();
			}
			
		} else if (currentKey == KeyCode.D || currentKey == KeyCode.RIGHT) {
			
			if (collideWithWall()) {
				positionX = positionX - SPEEDX;
				currentKey = null;
			} else {
				moveRight();
			}
			
		}

		collideWithFood();
		
		if (positionX >= Main.getStage().getWidth()) {
			positionX = 0;
		} else if (positionX < 0) {
			positionX = (int) Main.getStage().getWidth();
		}
		
		
	}

}
