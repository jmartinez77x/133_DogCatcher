//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 2 of the Dog Catcher Game
// 
// This class handles the "Sound" command. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a2;

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
		if(game == null)
			game = gw;
	}
	
	//ACTUALLY PERFORM THE ACTION
	public void actionPerformed(ActionEvent e){
		System.out.println("SOUND ON/OFF");
		game.toggleSound();
	}
}
