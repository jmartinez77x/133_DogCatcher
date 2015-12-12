//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Dog Catcher Game
// 
// This class handles the "Sound" command. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a4;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class SoundCommand extends AbstractAction{

	private static SoundCommand soundCommand;
	private static GameWorld game;
	
	private SoundCommand(){
		super("Sound On/Off");
	}
	
	//ONLY ONE INSTANCE
	public static SoundCommand getInstance(){
		if(soundCommand == null)
			soundCommand = new SoundCommand();
		return soundCommand;
	}
	
	//FOR ACCESSING GAMEWORLD FUNCTIONS
	public static void setTarget(GameWorld gw){
		if(game == null){
			game = gw;
		}
			
	}
	
	//ACTUALLY PERFORM THE ACTION
	public void actionPerformed(ActionEvent e){
		game.toggleSound();
		
		if(game.isSoundOn()){
			game.turnOnSound();
		}
		else{
			game.turnOffSound();
		}
	}
}
