//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Dog Catcher Game
// 
// This class contains all functions and data
// for all Game Objects.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a3;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public abstract class GameObject implements IDrawable, ICollider{
	private int size;
	private Color color;
	private float xLoc;
	private float yLoc;
	private int gWidth = 700;
	private int gHeight = 600;
	Random rand = new Random();

	public int getGameWidth() {
		return gWidth;
	}
	
	public int getGameHeight() {
		return gHeight;
	}

	public void incColor() {
		// color = color.brighter();
		color = color.darker();
	}

	public int getRed() {
		return color.getRed();
	}

	public int getGreen() {
		return color.getGreen();
	}

	public int getBlue() {
		return color.getBlue();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public float getXLoc() {
		return xLoc;
	}

	public float getYLoc() {
		return yLoc;
	}

	public void setLocation(float x, float y) {
		if(x > 0 && x < getGameWidth()){
			xLoc = x;
		}else{
			xLoc = rand.nextFloat() * (getGameWidth() - (getSize() / 2));
		}
		if(y > 0 && y < getGameHeight()){
			yLoc = y;
		}else{
			yLoc = rand.nextFloat() * (getGameHeight() - (getSize() / 2));
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void randSize() {
		// (maxAnimalSize - minAnimalSize) + minAnimalSize;
		size = rand.nextInt(50 - 20) + 20;
	}

	public void randLocation() { // RANDOM LOCATION WITHIN BOUNDARIES
		setLocation(rand.nextFloat() * (getGameWidth() - (getSize() / 2)),
				rand.nextFloat() * (getGameHeight() - (getSize() / 2)));
	}

	public String fToString(float x) { // FOR PRINTING LOCATION OF AN OBJECT
		return String.format("%.3f", x);
	}
	
	public abstract void draw(Graphics g);
	
	public boolean collidesWith(ICollider obj) {
		if(getRight() <= obj.getLeft() || getLeft() >= obj.getRight()){
			return false;
		}
		if(obj.getTop() <= getBottom() || getTop() <= obj.getBottom()){
			return false;
		}
		return true;
	}
}
