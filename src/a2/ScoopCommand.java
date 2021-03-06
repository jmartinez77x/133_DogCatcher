//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 2 of the Dog Catcher Game
// 
// This class handles the "Scoop" command. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a2;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class ScoopCommand extends AbstractAction{
	
	private static ScoopCommand scoopCommand;
	private static GameWorld game;
	
	private ScoopCommand(){
		super("Scoop Net");
	}
	
	//ONLY ONE INSTANCE
	public static ScoopCommand getInstance(){
		if(scoopCommand == null)
			scoopCommand = new ScoopCommand();
		return scoopCommand;
	}
	
	//FOR ACCESSING GAMEWORLD FUNCTIONS
	public static void setTarget(GameWorld gw){
		if(game == null)
			game = gw;
	}

	//ACTUALLY PERFORM THE ACTION
	public void actionPerformed(ActionEvent e) {
		System.out.println("SCOOPING NET");
		game.scoop();
	}
}
