//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 2 of the Dog Catcher Game
// 
// This class handles the "Tick" command. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a3;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class TickCommand extends AbstractAction{

	private static TickCommand tickCommand;
	private static GameWorld game;
	private static int tickTime;
	private static int tickCount;
	
	private TickCommand(){
		super("Tick Clock");
	}
	
	//ONLY ONE INSTANCE
	public static TickCommand getInstance(){
		if(tickCommand == null)
			tickCommand = new TickCommand();
		return tickCommand;
	}
	
	//FOR ACCESSING GAMEWORLD FUNCTIONS
	public static void setTarget(GameWorld tgw){
		if(game == null)
			game = tgw;
	}
	
	//SET TICK INTERVAL (20 MS)
	public static void setInterval(int delay) {
		tickTime = delay;
	}
	
	//ACTUALLY PERFORM THE ACTION
	public void actionPerformed(ActionEvent e){
		//System.out.println("ADVANCED GAME CLOCK");
		game.detectCollision();
		game.tickClock();
	}
}
