//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Dog Catcher Game
// 
// This class handles functions regarding Cat.
// There is an empty setColor() because the 
// changing of the cat's color is not allowed.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a3;

import java.awt.Graphics;
import java.awt.Point;

public class Cat extends Animal {
	
	private boolean kittenFlag;

	public void setColor() {
		// BLANK. CAN'T CHANGE COLOR OF CAT
	}

	// PRINT CAT INFORMATION
	public String toString() {
		String catInfo = "Cat:";
		catInfo += " loc=" + fToString(getXLoc()) + ", " + fToString(getYLoc());
		catInfo += " color=[" + getRed() + "," + getGreen() + "," + getBlue() + "]";
		catInfo += " size=" + getSize();
		catInfo += " speed=" + getSpeed();
		catInfo += " direction=" + getDirection();

		return catInfo;
	}

	public String getType() {
		return "Cat";
	}

	public boolean isKitten() {
		return kittenFlag;
	}
	
	public void setKitten(boolean bool){
		if(bool){
			kittenFlag = true;
		}else{
			kittenFlag = false;
		}
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
		g.setColor(getColor());
		
		Point top      = new Point((int)getXLoc(), (int)getYLoc() + halfSize);
		Point botLeft  = new Point((int)getXLoc() - halfSize, (int)getYLoc() - halfSize);
		Point botRight = new Point((int)getXLoc() + halfSize, (int)getYLoc() - halfSize);
		
		int [] xPts = new int [] {top.x, botLeft.x, botRight.x} ;
		int [] yPts = new int [] {top.y, botLeft.y, botRight.y} ;
		
		g.fillPolygon(xPts, yPts, 3);
	}
}
