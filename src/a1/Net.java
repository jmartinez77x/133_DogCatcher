//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 1 of the Dog Catcher Game
// 
// This class does the actual manipulating
// of the net functions.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a1;

public class Net extends Catcher {

	// PRINT NET INFORMATION
	public String toString() {
		String netInfo = "Net:";
		netInfo += " loc=" + fToString(getXLoc()) + ", " + fToString(getYLoc());
		netInfo += " color=[" + getRed() + "," + getGreen() + "," + getBlue()
				+ "]";
		netInfo += " size=" + getSize();

		return netInfo;
	}
}
