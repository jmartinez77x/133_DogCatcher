//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 2 of the Dog Catcher Game
// 
// This class handles the "Expand" command
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a2;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class ExpandCommand extends AbstractAction{
	
	private static ExpandCommand expandCommand;
	private static GameWorld game;
	
	private ExpandCommand(){
		super("Expand Net");
	}
	
	//ONLY ONE INSTANCE
	public static ExpandCommand getInstance(){
		if(expandCommand == null)
			expandCommand = new ExpandCommand();
		return expandCommand;
	}

	//FOR ACCESSING GAMEWORLD FUNCTIONS
	public static void setTarget(GameWorld gw){
		if(game == null)
			game = gw;
	}
	
	
	//ACTUALLY PERFORM THE ACTION
	public void actionPerformed(ActionEvent e) {
		System.out.println("EXPANDING NET");
		game.expandNet();
	}
}
