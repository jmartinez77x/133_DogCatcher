//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Dog Catcher Game
// 
// This class handles the "Up" command. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a3;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class UpCommand extends AbstractAction{
	
	private static UpCommand upCommand;
	private static GameWorld game;
	
	private UpCommand(){
		super("Move Net Up");
	}
	
	//ONLY ONE INSTANCE
	public static UpCommand getInstance(){
		if(upCommand == null)
			upCommand = new UpCommand();
		return upCommand;
	}

	//FOR ACCESSING GAMEWORLD FUNCTIONS
	public static void setTarget(GameWorld gw){
		if(game == null)
			game = gw;
	}
	
	//ACTUALLY PERFORM THE ACTION
	public void actionPerformed(ActionEvent e) {
		game.netUp();
	}
}
