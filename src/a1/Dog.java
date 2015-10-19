//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 1 of the Dog Catcher Game
// 
// This class handles the functions only used by Dog.
//	Mainly regarding scratches. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a1;

public class Dog extends Animal {
	private int scratches;

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
}
