//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Dog Catcher Game
// 
// This is the interface that implements
// the selection of game objects. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a4;

import java.awt.Graphics;
//import java.awt.Point;
import java.awt.geom.Point2D;

public interface ISelectable {
	//SELECT AN OBJECT OR GROUP OF OBJECTS (ONLY DOGS)
	//PERFORM CERTAIN ACTIONS ON THE SELECTED OBJECT
	//HIGHLIGHT SELECTED OBJECTS
	//ONLY IN PAUSE MODE - IF GAME RESUMED OBJECTS ARE UNSELECTED
	
	public void setSelected(boolean select);
	public boolean isSelected();
	public boolean contains(Point2D.Float p);
	public void draw(Graphics g);
}
