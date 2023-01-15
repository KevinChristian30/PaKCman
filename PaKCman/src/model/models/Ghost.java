package model.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import view.PlayScreenView;

public class Ghost extends GameObject{

	public int SPEED = 3;
	public final int WIDTH = 20;
	public int positionX, positionY;
	private Color color;
	
	public Ghost(int positionX, int positionY, Color color) {
		
		this.positionX = positionX;
		this.positionY = positionY;
		this.color = color;
		
	}

	@Override
	public void render(GraphicsContext GC) {
		
		GC.setFill(this.color);
		GC.fillArc(positionX, positionY, WIDTH, WIDTH, 
				0, Math.toDegrees(2 * Math.PI), ArcType.ROUND);
		
	}
	
	private boolean willCollideWithWall(int positionX, int positionY) {
		
		for (Wall e : GameMap.walls) {
			if(positionX < e.positionX + e.width &&
				positionX + WIDTH > e.positionX &&
				positionY < e.positionY + e.width &&
				positionY + WIDTH > e.positionY) {
				return true;
			}
		}
		return false;
		
	}
	
	private double calculateDistance(double posX, double posY) {
		
		double distanceX = Math.abs(PlayScreenView.pacman.positionX - posX);
		double distanceY = Math.abs(PlayScreenView.pacman.positionY - posY);
		return Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
		
	}
	
	private String getDirection() {
		
		double minCost = Double.MAX_VALUE;
		String minDir = "UP";
		
		// Up
		double UP = calculateDistance(this.positionX, 
						this.positionY - this.SPEED);
		if (UP < minCost && !willCollideWithWall(this.positionX, 
							this.positionY - SPEED)) {
			minCost = UP;
			minDir = "UP";
		}
		
		// Right
		double RIGHT = calculateDistance(this.positionX + this.SPEED, 
				this.positionY);
		if (RIGHT < minCost && !willCollideWithWall(this.positionX + SPEED, 
				this.positionY)) {
			minCost = RIGHT;
			minDir = "RIGHT";
		}
		
		// DOWN
		double DOWN = calculateDistance(this.positionX, 
				this.positionY + this.SPEED);
		if (DOWN < minCost && !willCollideWithWall(this.positionX, 
				this.positionY + SPEED)) {
			minCost = DOWN;
			minDir = "DOWN";
		}
		
		// Left
		double LEFT = calculateDistance(this.positionX - this.SPEED, 
				this.positionY);
		if (LEFT < minCost && !willCollideWithWall(this.positionX - SPEED, 
				this.positionY)) {
			minCost = LEFT;
			minDir = "LEFT";
		}
		
		return minDir;
		
	}
	
	public void change() {
		
		String direction = getDirection();
		switch(direction) {
			
		case "UP":			
			this.positionY -= SPEED;
			break;
		case "RIGHT":
			this.positionX += SPEED;
			break;
		case "DOWN":
			this.positionY += SPEED;
			break;
		case "LEFT":
			this.positionX -= SPEED;
			break;
		
		}
		
	}
	
}
