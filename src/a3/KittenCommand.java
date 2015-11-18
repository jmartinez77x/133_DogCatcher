//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 2 of the Dog Catcher Game
// 
// This class handles the "Kitten" command. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a3;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class KittenCommand extends AbstractAction{
	
	private static KittenCommand kittenCommand;
	private static GameWorld game;
	
	private KittenCommand(){
		super("New Kitten");
	}
	
	//ONLY ONE INSTANCE
	public static KittenCommand getInstance(){
		if(kittenCommand == null){
			kittenCommand = new KittenCommand();
		}
		return kittenCommand;
	}
	
	//FOR ACCESSING GAMEWORLD FUNCTIONS
	public static void setTarget(GameWorld gw){
		if(game == null){
			game = gw;
		}
	}

	//ACTUALLY PERFORM THE ACTION
	public void actionPerformed(ActionEvent e) {
		//System.out.println("CAT COLLISION"); 
		game.catCollision();
	}
}
