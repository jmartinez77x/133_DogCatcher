package a3;

import java.awt.Graphics;
import java.awt.Point;

public interface ISelectable {
	//SELECT AN OBJECT OR GROUP OF OBJECTS (ONLY DOGS)
	//PERFORM CERTAIN ACTIONS ON THE SELECTED OBJECT
	//HIGHLIGHT SELECTED OBJECTS
	//ONLY IN PAUSE MODE - IF GAME RESUMED OBJECTS ARE UNSELECTED
	
	// way to mark an object as selected or not
	public void setSelected(boolean yesNo);
	
	// see if it is selected
	public boolean isSelected();
	
	// is the mouse in it to select on click?
	public boolean contains(Point p);
	
	// way to draw the object which knows about
	// if it is selected or not
	public void draw(Graphics g);
}
