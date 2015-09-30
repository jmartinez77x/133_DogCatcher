package a1;
import java.util.Random;
import java.awt.Color;

public class Net extends Catcher{
	private int size;
	private int minNetSize = 50;
	private int maxNetSize = 500;
	private Color color;
	Location loc;
	Random rand = new Random();
	
	//CONSTRUCT OBJECT
	Net(){
		loc = new Location(rand.nextFloat()*1024, rand.nextFloat()*1024); //NEW RANDOM LOCATION
		size = 100;
		color = Color.BLACK;
	}
	
	//METHODS
	public void move(){
		
	}
	public void setSize(){
		size = rand.nextInt(maxNetSize - minNetSize) + minNetSize;
	}
	public int getSize(){
		return size;
	}
	public void guide(){
		
	}
	public String toString(){
		String netInfo = "Net:";
		netInfo += " loc=" + loc.getX() + "," + loc.getY();
		netInfo += " color=[" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "]";
		netInfo += " size=" + getSize();
		
		return netInfo;
	}
}
