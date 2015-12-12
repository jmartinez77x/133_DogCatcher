//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Dog Catcher Game
// 
// This class contains all functions and data
// for the Catcher Object.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a4;

public abstract class Catcher extends GameObject implements IGuidable {
	
	private int netSpeed = 10;

	public void expandNet() {
		float x, y;
		
		setSize(getSize() + netSpeed);
		
//		// CHECK RIGHT SIDE
//		if (getXLoc() > getGameWidth() - (getSize() / 2)) {
//			x = getGameWidth() - (getSize() / 2);
//			y = getYLoc();
//			setLocation(x, y);
//		}
//		// CHECK LEFT SIDE
//		if (getXLoc() < getSize() / 2) {
//			x = getSize() / 2;
//			y = getYLoc();
//			setLocation(x, y);
//		}
//		// CHECK TOP
//		if (getYLoc() > getGameHeight() - (getSize() / 2)) {
//			y = getGameHeight() - (getSize() / 2);
//			x = getXLoc();
//			setLocation(x, y);
//		}
//		// CHECK BOTTOM
//		if (getYLoc() < getSize() / 2) {
//			y = getSize() / 2;
//			x = getXLoc();
//			setLocation(x, y);
//		}
	}

	public void contractNet() {
		setSize(getSize() - netSpeed);
	}

	public void scoop() {
	}

	public void netRight() {
		float x = getXLoc();
		x = x + netSpeed;

//		// CHECK RIGHT SIDE
//		if (x > getGameWidth() - (getSize() / 2)) {
//			x = getGameWidth() - (getSize() / 2);
//		}
		setLocation(x, getYLoc());
	}

	public void netLeft() {
		float x = getXLoc();
		x = x - netSpeed;

//		// CHECK LEFT SIDE
//		if (x < getSize() / 2) {
//			x = getSize() / 2;
//		}
		setLocation(x, getYLoc());
	}

	public void netUp() {
		float y = getYLoc();
		y = y + netSpeed;

//		// CHECK TOP
//		if (y > getGameHeight() - (getSize() / 2)) {
//			y = getGameHeight() - (getSize() / 2);
//		}
		setLocation(getXLoc(), y);
	}

	public void netDown() {
		float y = getYLoc();
		y = y - netSpeed;

//		// CHECK BOTTOM
//		if (y < getSize() / 2) {
//			y = getSize() / 2;
//		}
		setLocation(getXLoc(), y);
	}
}
