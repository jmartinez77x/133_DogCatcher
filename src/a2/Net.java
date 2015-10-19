//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 2 of the Dog Catcher Game
// 
// This class handles any functions specific 
// to the Net object. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a2;

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
