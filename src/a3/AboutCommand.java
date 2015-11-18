//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 2 of the Dog Catcher Game
// 
// This class handles the "About" command
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a3;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class AboutCommand extends AbstractAction{

	private static AboutCommand aboutCommand;
	
	private AboutCommand(){
		super("About");
	}
	
	//ONLY ONE INSTANCE
	public static AboutCommand getInstance(){
		if(aboutCommand == null)
			aboutCommand = new AboutCommand();
		return aboutCommand;
	}
	
	//ACTUALLY PERFORM THE ACTION
	public void actionPerformed(ActionEvent e){
		//System.out.println("ABOUT");
		JOptionPane.showMessageDialog(null, "Joe Martinez\n" + "CSC 133 A2\n" + "Fall 2015");
	}
}
