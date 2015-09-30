package a1;
import java.util.Random;
import java.awt.Color;

public class Cat extends Animal{
	private int size;
	private int minCatSize = 1;
	private int maxCatSize = 10;
	private int speed;
	private int minCatSpeed = 1;
	private int maxCatSpeed = 10;
	private int direction;
	private Color color; 
	Location loc;
	Random rand = new Random();
	
	//CONSTRUCT CAT
	Cat(){
		loc = new Location(rand.nextFloat()*1024, rand.nextFloat()*1024); //NEW RANDOM LOCATION
		randSize(); //NEW RANDOM SIZE
		randSpeed();
		randDirection();
		color = Color.CYAN;
	}
	
	//METHODS
	public void move(){
		
	}
	public void randSize(){
		size = rand.nextInt(maxCatSize - minCatSize) + minCatSize;
	}
	public void randSpeed(){
		speed = rand.nextInt(maxCatSpeed - minCatSpeed) + minCatSpeed;
	}
	public void randDirection(){
		direction = rand.nextInt(360);
	}
	public int getSize(){
		return size;
	}
	public int getDirection(){
		return direction;
	}
	public int getSpeed(){
		return speed;
	}
	public Color getColor(){
		return color;
	}
	public String toString(){
		String catInfo = "Cat:";
		catInfo += " loc=" + loc.getX() + "," + loc.getY();
		catInfo += " color=[" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "]";
		catInfo += " size=" + getSize();
		catInfo += " speed=" + getSpeed();
		catInfo += " direction=" + getDirection();
		
		return catInfo;
	}
}
