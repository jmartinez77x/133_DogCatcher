//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 2 of the Dog Catcher Game
// 
// This class contains all functions and data
// for the Catcher Object.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a3;

public abstract class Catcher extends GameObject implements IGuidable {

	public void expandNet() {
		float x, y;
		
		setSize(getSize() + 7);
		
		// CHECK RIGHT SIDE
		if (getXLoc() > getGameWidth() - (getSize() / 2)) {
			x = getGameWidth() - (getSize() / 2);
			y = getYLoc();
			setLocation(x, y);
		}
		// CHECK LEFT SIDE
		if (getXLoc() < getSize() / 2) {
			x = getSize() / 2;
			y = getYLoc();
			setLocation(x, y);
		}
		// CHECK TOP
		if (getYLoc() > getGameHeight() - (getSize() / 2)) {
			y = getGameHeight() - (getSize() / 2);
			x = getXLoc();
			setLocation(x, y);
		}
		// CHECK BOTTOM
		if (getYLoc() < getSize() / 2) {
			y = getSize() / 2;
			x = getXLoc();
			setLocation(x, y);
		}
	}

	public void contractNet() {
		setSize(getSize() - 7);
	}

	public void scoop() {
	}

	public void netRight() {
		float x = getXLoc();
		x = x + 7f;

		// CHECK RIGHT SIDE
		if (x > getGameWidth() - (getSize() / 2)) {
			x = getGameWidth() - (getSize() / 2);
		}
		setLocation(x, getYLoc());
	}

	public void netLeft() {
		float x = getXLoc();
		x = x - 7f;

		// CHECK LEFT SIDE
		if (x < getSize() / 2) {
			x = getSize() / 2;
		}
		setLocation(x, getYLoc());
	}

	public void netUp() {
		float y = getYLoc();
		y = y + 7f;

		// CHECK TOP
		if (y > getGameHeight() - (getSize() / 2)) {
			y = getGameHeight() - (getSize() / 2);
		}
		setLocation(getXLoc(), y);
	}

	public void netDown() {
		float y = getYLoc();
		y = y - 7f;

		// CHECK BOTTOM
		if (y < getSize() / 2) {
			y = getSize() / 2;
		}
		setLocation(getXLoc(), y);
	}
}
