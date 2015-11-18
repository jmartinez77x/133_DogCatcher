//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 2 of the Dog Catcher Game
// 
// This class handles the "Contract" command
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a3;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class ContractCommand extends AbstractAction{
	
	private static ContractCommand contractCommand;
	private static GameWorld game;
	
	private ContractCommand(){
		super("Contract Net");
	}
	
	//ONLY ONE INSTANCE
	public static ContractCommand getInstance(){
		if(contractCommand == null)
			contractCommand = new ContractCommand();
		return contractCommand;
	}
	
	//FOR ACCESSING GAMEWORLD FUNCTIONS
	public static void setTarget(GameWorld gw){
		if(game == null)
			game = gw;
	}
	
	//ACTUALLY PERFORM THE ACTION
	public void actionPerformed(ActionEvent e) {
		//System.out.println("CONTRACTING NET");
		game.contractNet();
	}
}