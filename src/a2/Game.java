//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 2 of the Dog Catcher Game
// 
// This class is used to set up the initial game
// and then get input from the user to control
// the game. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a2;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.border.*;

@SuppressWarnings("serial")
public class Game extends JFrame{
	
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;

	public Game() {
		gw = new GameWorld(); 	//OBSERVERABLE
		mv = new MapView();
		sv = new ScoreView();
		gw.initLayout();
		guiSetup();
		gw.addObserver(mv);		//OBSERVER
		gw.addObserver(sv);		//OBSERVER
		gw.notifyObservers();
	}
	
	private void guiSetup(){
		
		//KEYSTROKE SETUP FOR ARROW KEYS AND SELECTED CHAR KEYS
		KeyStroke upKey    = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0);
		KeyStroke downKey  = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0);
		KeyStroke leftKey  = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0);
		KeyStroke rightKey = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);
		KeyStroke sKey     = KeyStroke.getKeyStroke(KeyEvent.VK_S, 0);
		KeyStroke rKey     = KeyStroke.getKeyStroke(KeyEvent.VK_R, 0);
		KeyStroke lKey     = KeyStroke.getKeyStroke(KeyEvent.VK_L, 0);
		KeyStroke uKey     = KeyStroke.getKeyStroke(KeyEvent.VK_U, 0);
		KeyStroke dKey     = KeyStroke.getKeyStroke(KeyEvent.VK_D, 0);
		KeyStroke qKey     = KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0);
		
		//JFRAME SETUP
		JFrame frame = new JFrame("JM Dog Catcher");
		frame.setSize(1000,700);
		frame.setLocation(150,50);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//MENUBAR SETUP
		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);
		frame.setVisible(true);
		
		//FILE MENU
		JMenu file = new JMenu("File"); 
			bar.add(file);
		JMenuItem newMI = new JMenuItem("New");
			//newMI.setAction(Command.getInstance());
			file.add(newMI); 
		JMenuItem save = new JMenuItem("Save"); 
			//save.setAction(Command.getInstance());
			file.add(save);
		JMenuItem undo = new JMenuItem("Undo"); 
			//undo.setAction(Command.getInstance());
			file.add(undo);
		JCheckBoxMenuItem sound = new JCheckBoxMenuItem("Sound On/Off");
			sound.setAction(SoundCommand.getInstance());
			sound.setState(true);
			file.add(sound); 
		JMenuItem about = new JMenuItem("About"); 
			about.setAction(AboutCommand.getInstance());
			file.add(about);
		
		//COMMAND MENU	
		JMenu commands = new JMenu("Commands"); 
			bar.add(commands);
		JMenuItem expandNet = new JMenuItem("Expand Net"); 
			expandNet.setAction(ExpandCommand.getInstance());
			commands.add(expandNet); 
		JMenuItem contractNet = new JMenuItem("Contract Net"); 
			contractNet.setAction(ContractCommand.getInstance());	
			commands.add(contractNet);
		JMenuItem kitten = new JMenuItem("Kiten"); 
			kitten.setAction(KittenCommand.getInstance());	
			commands.add(kitten);
		JMenuItem fight = new JMenuItem("Fight"); 
			fight.setAction(FightCommand.getInstance());	
			commands.add(fight);
		JMenuItem quit = new JMenuItem("Quit"); 
			quit.setAction(QuitCommand.getInstance());
			commands.add(quit);
			
		//SCOREVIEW SETUP
		sv = new ScoreView();
		frame.add(sv, BorderLayout.NORTH);	
			
		//COMMAND BUTTONS SETUP
		JPanel buttonPanel = new JPanel(); 
			buttonPanel.setBorder(new TitledBorder("Commands:")); 
			buttonPanel.setLayout (new GridLayout (10,1));
		JButton expandButton = new JButton ("Expand Net"); 
			expandButton.setAction(ExpandCommand.getInstance());
			buttonPanel.add(expandButton);
		JButton contractButton = new JButton ("Contract Net"); 
			contractButton.setAction(ContractCommand.getInstance());
			buttonPanel.add(contractButton);
		JButton scoopButton = new JButton ("Scoop"); 		
			scoopButton.setAction(ScoopCommand.getInstance());
			buttonPanel.add(scoopButton);
		JButton rightButton = new JButton ("Move Net Right"); 
			rightButton.setAction(RightCommand.getInstance());
			buttonPanel.add(rightButton);
		JButton leftButton = new JButton ("Move Net Left"); 	
			leftButton.setAction(LeftCommand.getInstance());
			buttonPanel.add(leftButton);
		JButton upButton = new JButton ("Move Net Up"); 	
			upButton.setAction(UpCommand.getInstance());
			buttonPanel.add(upButton);
		JButton downButton = new JButton ("Move Net Down"); 	
			downButton.setAction(DownCommand.getInstance());
			buttonPanel.add(downButton);
		JButton kittenButton = new JButton ("New Kitten");
			kittenButton.setAction(KittenCommand.getInstance());
			buttonPanel.add(kittenButton);
		JButton fightButton = new JButton ("Fight"); 	
			fightButton.setAction(FightCommand.getInstance());
			buttonPanel.add(fightButton);
		JButton tickButton = new JButton ("Tick Clock"); 
			tickButton.setAction(TickCommand.getInstance());
			buttonPanel.add(tickButton);
		frame.add(buttonPanel, BorderLayout.WEST);
		
		//MAPVIEW SETUP
		mv = new MapView();
		frame.add(mv, BorderLayout.CENTER);
		
		//IMAP
		int map = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap iMap = mv.getInputMap(map);
		
		iMap.put(sKey, "Scoop Net");
		iMap.put(rKey, "Move Net Right");
		iMap.put(lKey, "Move Net Left");
		iMap.put(uKey, "Move Net Up");
		iMap.put(dKey, "Move Net Down");
		iMap.put(qKey, "Quit");
		
		iMap.put(rightKey, "Move Net Right");
		iMap.put(leftKey, "Move Net Left");
		iMap.put(upKey, "Move Net Up");
		iMap.put(downKey, "Move Net Down");
		
		//AMAP
		ActionMap aMap = mv.getActionMap();
		
		aMap.put("Scoop Net", ScoopCommand.getInstance());
		aMap.put("Move Net Right", RightCommand.getInstance());
		aMap.put("Move Net Left", LeftCommand.getInstance());
		aMap.put("Move Net Up", UpCommand.getInstance());
		aMap.put("Move Net Down", DownCommand.getInstance());
		aMap.put("Quit", QuitCommand.getInstance());
		
		this.requestFocus();
		
		//SET TARGETS FOR COMMANDS
		ExpandCommand.setTarget(gw);
		ContractCommand.setTarget(gw);
		ScoopCommand.setTarget(gw);
		RightCommand.setTarget(gw);
		LeftCommand.setTarget(gw);
		UpCommand.setTarget(gw);
		DownCommand.setTarget(gw);
		KittenCommand.setTarget(gw);
		FightCommand.setTarget(gw);
		TickCommand.setTarget(gw);	
		SoundCommand.setTarget(gw);
		
		frame.setVisible(true);
		frame.toFront();
	}
}
