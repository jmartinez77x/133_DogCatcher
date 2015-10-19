//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 1 of the Dog Catcher Game
// 
// This class handles functions regarding Cat.
// There is an empty setColor() because the 
// changing of the cat's color is not allowed.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a1;

public class Cat extends Animal {

	public void setColor() {
		// BLANK. CAN'T CHANGE COLOR OF CAT
	}

	// PRINT CAT INFORMATION
	public String toString() {
		String catInfo = "Cat:";
		catInfo += " loc=" + fToString(getXLoc()) + ", " + fToString(getYLoc());
		catInfo += " color=[" + getRed() + "," + getGreen() + "," + getBlue()
				+ "]";
		catInfo += " size=" + getSize();
		catInfo += " speed=" + getSpeed();
		catInfo += " direction=" + getDirection();

		return catInfo;
	}
}
