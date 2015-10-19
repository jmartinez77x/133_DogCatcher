//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 2 of the Dog Catcher Game
// 
// This class contains all functions and data
// for all Game Objects.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a2;

import java.awt.Color;
import java.util.Random;

public abstract class GameObject {
	private int size;
	private Color color;
	private float xLoc;
	private float yLoc;
	private int gHeight = 1024;
	private int gWidth = 1024;
	Random rand = new Random();

	public int getHeight() {
		return gHeight;
	}

	public int getWidth() {
		return gWidth;
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
		this.xLoc = x;
		this.yLoc = y;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void randSize() {
		// (maxAnimalSize - minAnimalSize) + minAnimalSize;
		size = rand.nextInt(10 - 2) + 2;
	}

	public void randLocation() { // RANDOM LOCATION WITHIN BOUNDARIES
		setLocation(rand.nextFloat() * (getWidth() - (getSize() / 2)),
				rand.nextFloat() * (getHeight() - (getSize() / 2)));
	}

	public String fToString(float x) { // FOR PRINTING LOCATION OF AN OBJECT
		return String.format("%.3f", x);
	}
}
