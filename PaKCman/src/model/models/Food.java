package model.models;

public class Food {

	public static int FOODWIDTH = 5;
	
	private int positionX, positionY, radius;
	
	public Food(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.radius = FOODWIDTH;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
}
