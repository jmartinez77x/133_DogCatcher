//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 1 of the Dog Catcher Game
// 
// This class contains all functions and data
// for the Catcher Object.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a1;

public abstract class Catcher extends GameObject implements IGuidable {

	public void expandNet() {
		setSize(getSize() + 7);
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
		if (x > getWidth() - (getSize() / 2)) {
			x = getWidth() - (getSize() / 2);
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
		if (y > getHeight() - (getSize() / 2)) {
			y = getHeight() - (getSize() / 2);
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
