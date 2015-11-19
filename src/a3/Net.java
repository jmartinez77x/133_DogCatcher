//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Dog Catcher Game
// 
// This class handles any functions specific 
// to the Net object. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a3;

import java.awt.Graphics;

public class Net extends Catcher {
	
	public boolean collidesWith(ICollider obj) {
		return false;
	}

	public String getType() {
		return null;
	}
	
	public void handleCollision(ICollider obj1, ICollider obj2, GameWorld gw){
		//CAN'T COLLIDE WITH NET
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
	
	// PRINT NET INFORMATION - UNUSED IN A3
	public String toString() {
		String netInfo = "Net:";
		netInfo += " loc=" + fToString(getXLoc()) + ", " + fToString(getYLoc());
		netInfo += " color=[" + getRed() + "," + getGreen() + "," + getBlue()
				+ "]";
		netInfo += " size=" + getSize();

		return netInfo;
	}

	public void draw(Graphics g) {
		int halfSize = getSize()/2;
		g.setColor(getColor());
		g.setColor(getColor());
		g.drawRect((int)getXLoc() - halfSize, (int)getYLoc() - halfSize, getSize(), getSize());	
	}

	public void flashNet(Graphics g) {
		int halfSize = getSize()/2;
		g.setColor(getColor());
		g.fillRect((int)getXLoc() - halfSize, (int)getYLoc() - halfSize, getSize(), getSize());
	}
}
