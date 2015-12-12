//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Dog Catcher Game
// 
// This class handles the functions only used by Dog.
//	Mainly regarding scratches. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.Point;
import java.awt.geom.Point2D;

public class Dog extends Animal implements ISelectable{
	private int scratches;
	private boolean selected;

	public void incScratches() {
		scratches++;

		// SET SPEED TO ZERO IF SCRATCHES = 5
		if (scratches >= 5) {
			setSpeed(0);// DOG STOPS MOVING
		}
	}

	public int getScratches() {
		return scratches;
	}
	
	public void resetScratches() {
		scratches = 0;
	}

	// PRINT DOG INFORMATION
	public String toString() {
		String dogInfo = "Dog:";
		dogInfo += " loc=" + fToString(getXLoc()) + ", " + fToString(getYLoc());
		dogInfo += " color=[" + getRed() + "," + getGreen() + "," + getBlue()
				+ "]";
		dogInfo += " size=" + getSize();
		dogInfo += " speed=" + getSpeed();
		dogInfo += " direction=" + getDirection();
		dogInfo += " scratches=" + getScratches();

		return dogInfo;
	}

	public String getType() {
		return "Dog";
	}

	public int getLeft() {
		return (int)(getXLoc() - getSize()/2); 
	}

	public int getRight() {
		return (int)(getXLoc() + getSize()/2);
	}

	public int getTop() {
		return (int)(getYLoc() + getSize()/2);
	}

	public int getBottom() {
		return (int)(getYLoc() - getSize()/2);
	}

	public void draw(Graphics g) {
		int halfSize = getSize()/2;
		
		if(isSelected()){
			g.setColor(Color.CYAN);
			g.fillOval((int)getXLoc()- halfSize, (int)getYLoc() - halfSize, getSize(), getSize());
		}else{
			g.setColor(getColor());
			//MAIN
			g.drawOval((int)getXLoc()- halfSize, (int)getYLoc() - halfSize, getSize(), getSize());
//			//TOP LEFT
//			g.drawOval((int)getXLoc()- halfSize, (int)getYLoc() + halfSize, getSize()/3, getSize()/3);
//			//TOP RIGHT
//			g.drawOval((int)getXLoc()+ getSize()/3, (int)getYLoc() + getSize()/4, getSize()/3, getSize()/3);
//			//BOTTOM LEFT
//			g.drawOval((int)getXLoc()- getSize()/2, (int)getYLoc() - halfSize, getSize()/3, getSize()/3);
//			//BOTTOM RIGHT
//			g.drawOval((int)getXLoc()+ halfSize, (int)getYLoc() - halfSize, getSize()/3, getSize()/3);
			g.drawLine((int)getXLoc() - halfSize, (int)getYLoc() - halfSize, 5, 5);
		}
	}

	public void setSelected(boolean select) {
		selected = select;
	}
	
	public boolean isSelected() {
		return selected;
	}

	public boolean contains(Point2D.Float p) {
		float x1, x2, y1, y2;
		x1 = getXLoc()-(getSize()/2);
		x2 = getXLoc()+(getSize()/2);
		y1 = getYLoc()-(getSize()/2);
		y2 = getYLoc()+(getSize()/2);
		
		if(p.getX() >= x1 && p.getX() <= x2){
			if(p.getY() >= y1 && p.getY() <= y2){ 
				return true;
			}
		}
		return false;
	}

	public void draw(Graphics2D twoD) {
		int halfSize = getSize()/2;
		
		if(isSelected()){
			twoD.setColor(Color.CYAN);
			twoD.fillOval((int)getXLoc()- halfSize, (int)getYLoc() - halfSize, getSize(), getSize());
			twoD.drawLine((int)getXLoc(), (int)getYLoc(), (int)getXLoc(), (int)(getYLoc()+getSize()/1.3));
		}else{
			twoD.setColor(getColor());
			twoD.drawOval((int)getXLoc() - halfSize, (int)getYLoc() - halfSize, getSize(), getSize());
			twoD.drawLine((int)getXLoc(), (int)getYLoc(), (int)getXLoc(), (int)(getYLoc()+getSize()/1.3));
		}
	}
}
