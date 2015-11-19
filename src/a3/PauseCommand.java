//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Dog Catcher Game
// 
// This class handles the "Pause" command. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a3;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class PauseCommand extends AbstractAction{
	
	private static PauseCommand pauseCommand;
	private static Game game;
	
	private PauseCommand(){
		super("Pause");
	}
	
	//ONLY ONE INSTANCE
	public static PauseCommand getInstance(){
		if(pauseCommand == null)
			pauseCommand = new PauseCommand();
		return pauseCommand;
	}
	
	//FOR ACCESSING GAMEWORLD FUNCTIONS
	public static void setTarget(Game g){
		if(game == null)
			game = g;
	}
	
	//ACTUALLY PERFORM THE ACTION
	public void actionPerformed(ActionEvent e){
		if(game.isPaused()){
			game.resumeGame();
		}
		else if(!game.isPaused()){
			game.pauseGame();
		}
	}
}
