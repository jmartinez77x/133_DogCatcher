//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Dog Catcher Game
// 
// This class handles the "Down" command
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a3;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class DownCommand extends AbstractAction{
	
	private static DownCommand downCommand;
	private static GameWorld game;
	
	private DownCommand(){
		super("Move Net Down");
	}
	
	//ONLY ONE INSTANCE
	public static DownCommand getInstance(){
		if(downCommand == null)
			downCommand = new DownCommand();
		return downCommand;
	}
	
	//FOR ACCESSING GAMEWORLD FUNCTIONS
	public static void setTarget(GameWorld gw){
		if(game == null)
			game = gw;
	}

	//ACTUALLY PERFORM THE ACTION
	public void actionPerformed(ActionEvent e) {
		game.netDown();
	}
}
