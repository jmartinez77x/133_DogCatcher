//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Dog Catcher Game
// 
// This class handles the "Quit" command. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a4;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class QuitCommand extends AbstractAction{

	private static QuitCommand quitCommand;
	
	private QuitCommand(){
		super("Quit");
	}
	
	//ONLY ONE INSTANCE
	public static QuitCommand getInstance(){
		if(quitCommand == null)
			quitCommand = new QuitCommand();
		return quitCommand;
	}
	
	//ACTUALLY PERFORM THE ACTION
	public void actionPerformed(ActionEvent e) {
		System.out.println("QUITTING GAME");
		
		int quit = JOptionPane.showConfirmDialog(null, "Do you really want to quit?",
				"Confirm Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(quit == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
