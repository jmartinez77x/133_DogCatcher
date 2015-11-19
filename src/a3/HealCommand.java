//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Dog Catcher Game
// 
// This class handles the "Heal" command. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a3;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class HealCommand extends AbstractAction{
	
	private static HealCommand healCommand;
	private static GameWorld game;
	
	private HealCommand(){
		super("Heal");
	}
	
	//ONLY ONE INSTANCE
	public static HealCommand getInstance(){
		if(healCommand == null)
			healCommand = new HealCommand();
		return healCommand;
	}
	
	//FOR ACCESSING GAMEWORLD FUNCTIONS
	public static void setTarget(GameWorld gw){
		if(game == null)
			game = gw;
	}
	
	//ACTUALLY PERFORM THE ACTION
	public void actionPerformed(ActionEvent e){
		game.healDogs();
	}
}
