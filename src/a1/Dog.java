package a1;
import java.util.Random;
import java.awt.Color;

public class Dog extends Animal{
	private int size;
	private int minDogSize = 1;
	private int maxDogSize = 10;
	private int speed;
	private int minDogSpeed = 1;
	private int maxDogSpeed = 10;
	private int direction;
	private int minDogDirection = 1;
	private int maxDogDirection = 359;
	private int scratches;
	private Color color;
	Location loc;
	Random rand = new Random();
	
	//CONSTRUCT DOG
	Dog(){
		scratches = 0;
		loc = new Location(rand.nextFloat()*1024, rand.nextFloat()*1024); //NEW RANDOM LOCATION
		randSize(); //NEW RANDOM SIZE
		randSpeed();
		randDirection();
		color = Color.yellow;
	}
	
	//SET METHODS
	public void move(){
		
	}
	public void randSize(){
		size = rand.nextInt(maxDogSize - minDogSize) + minDogSize;
	}
	public int getSize(){
		return size;
	}
	public void randSpeed(){
		speed = rand.nextInt(maxDogSpeed - minDogSpeed) + minDogSpeed;
	}
	public void randDirection(){
		direction = rand.nextInt(360);
	}
	public int getDirection(){
		return direction;
	}
	public int getSpeed(){
		return speed;
	}
	public int getScratches(){
		return scratches;
	}
	public String toString(){
		String dogInfo = "Dog:";
		dogInfo += " loc=" + loc.getX() + "," + loc.getY();
		dogInfo += " color=[" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "]";
		dogInfo += " size=" + getSize();
		dogInfo += " speed=" + getSpeed();
		dogInfo += " direction=" + getDirection();
		dogInfo += " scratches=" + getScratches();
		
		return dogInfo;
	}
}
