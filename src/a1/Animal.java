//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 1 of the Dog Catcher Game
// 
// This class contains all functions and data
// for the Animal Object.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a1;

public abstract class Animal extends GameObject implements IMovable {
	private int speed;
	private int direction;

	public void move() {
		float x = getXLoc();
		float y = getYLoc();

		float dx = (float) Math.cos(90 - getXLoc()) * this.speed;
		float dy = (float) Math.sin(90 - getYLoc()) * this.speed;

		x = x + dx; // NEW X LOCATION
		y = y + dy; // NEW Y LOCATION

		// CHECK LEFT SIDE
		if (x < getSize() / 2) {
			x = getSize() / 2 + rand.nextFloat() * getSize() / 2;
		}
		// CHECK RIGHT SIDE
		else if (x > getWidth() - (getSize() / 2)) {
			x = getWidth() - (getSize() / 2 + rand.nextFloat() * getSize() / 2);
		}

		// CHECK BOTTOM
		if (y < getSize() / 2) {
			y = getSize() / 2 + rand.nextFloat() * getSize() / 2;
		}
		// CHECK TOP
		else if (y > getHeight() - (getSize() / 2)) {
			y = getHeight()
					- (getSize() / 2 + rand.nextFloat() * getSize() / 2);
		}

		// //TESTING FOR X AND Y OUTSIDE OF BOUNDARIES
		// if(x < 0 || x > getWidth() || y < 0 || y > getHeight()){
		// System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
		// System.out.println("Size: " + getSize() + " ~~~ Dir: " +
		// getDirection() + " ~~~ x: " + x + " ~~~ getSize/2: " +
		// (getSize()/2));
		// }

		setLocation(x, y);
		setDirection(getDirection() + rand.nextInt(7));
	}

	public void decSpeed() { // DECREASE SPEED
		speed = speed - 1;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void randSpeed() {
		// (maxAnimalSpeed - minAnimalSpeed) + minAnimalSpeed;
		speed = rand.nextInt(5 - 1) + 1;
	}

	public void setSize() {
		// BLANK. CAN'T CHANGE SIZE
	}

	public void randDirection() {
		direction = rand.nextInt(360);
	}
}