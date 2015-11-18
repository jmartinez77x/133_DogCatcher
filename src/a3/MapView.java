//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 2 of the Dog Catcher Game
// 
// This class sets up and updates the "MapView".
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a3;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

@SuppressWarnings("serial")
public class MapView extends JPanel implements IObserver{
	
	private GameWorld gw;
	
	MapView(GameWorld game){
		setBackground(Color.gray);
		gw = game;
	}
	
	public void update(IObservable o) {
		//PRINT TEXT MAP IN CONSOLE
//		if(o instanceof GameWorld){
//			((GameWorld)o).printMap();
//		}
		repaint();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		IIterator iterator = gw.gObjects.getIterator();
		Object curObj = new Object();
		
		// iterate through, and print each one
		while(iterator.hasNext() ){
			curObj = iterator.getNext();
			if(curObj != null){
				if((GameObject)curObj instanceof Net && gw.flashNet){
					((Net)(GameObject)curObj).flashNet(g);
					gw.flashNet = false;
				}
				else{
					((GameObject)curObj).draw(g);
				}
			}
		}
		setVisible(true);
	}
}
