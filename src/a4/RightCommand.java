//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Dog Catcher Game
// 
// This class handles the "Right" command. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a4;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class RightCommand extends AbstractAction{
	
	private static RightCommand rightCommand;
	private static GameWorld game;
	
	private RightCommand(){
		super("Move Net Right");
	}
	
	//ONLY ONE INSTANCE
	public static RightCommand getInstance(){
		if(rightCommand == null)
			rightCommand = new RightCommand();
		return rightCommand;
	}
	
	//FOR ACCESSING GAMEWORLD FUNCTIONS
	public static void setTarget(GameWorld gw){
		if(game == null)
			game = gw;
	}

	//ACTUALLY PERFORM THE COMMAND
	public void actionPerformed(ActionEvent e) {
		game.netRight();
	}
}
