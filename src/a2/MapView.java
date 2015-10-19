//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 2 of the Dog Catcher Game
// 
// This class sets up and updates the "MapView".
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a2;

import java.awt.Color;

import javax.swing.*;

@SuppressWarnings("serial")
public class MapView extends JPanel implements IObserver{
	
	MapView(){
		setBackground(Color.gray);
	}
	
	public void update(IObservable o) {
		if(o instanceof GameWorld){
			((GameWorld)o).printMap();
		}
	}
}
