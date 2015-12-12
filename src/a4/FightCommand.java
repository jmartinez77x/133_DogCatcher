//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Dog Catcher Game
// 
// This class handles the "Fight" command
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a4;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class FightCommand extends AbstractAction{
	
	private static FightCommand fightCommand;
	private static GameWorld game;
	
	private FightCommand(){
		super("Fight");
	}
	
	//ONLY ONE INSTANCE
	public static FightCommand getInstance(){
		if(fightCommand == null)
			fightCommand = new FightCommand();
		return fightCommand;
	}
	
	//FOR ACCESSING GAMEWORLD FUNCTIONS
	public static void setTarget(GameWorld gw){
		if(game == null)
			game = gw;
	}

	//ACTUALLY PERFORM THE ACTION
	public void actionPerformed(ActionEvent e) {
		game.fightCollision();
	}
}
