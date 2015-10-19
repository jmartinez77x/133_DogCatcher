//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 2 of the Dog Catcher Game
// 
// This class handles the "Left" command. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a2;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class LeftCommand extends AbstractAction{
	
	private static LeftCommand leftCommand;
	private static GameWorld game;
	
	private LeftCommand(){
		super("Move Net Left");
	}
	
	//ONLY ONE INSTANCE
	public static LeftCommand getInstance(){
		if(leftCommand == null)
			leftCommand = new LeftCommand();
		return leftCommand;
	}
	
	//FOR ACCESSING GAMEWORLD FUNCTIONS
	public static void setTarget(GameWorld gw){
		if(game == null)
			game = gw;
	}

	//ACTUALLY PERFORM THE ACTION
	public void actionPerformed(ActionEvent e) {
		System.out.println("MOVING NET LEFT");
		game.netLeft();
	}
}
