//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 2 of the Dog Catcher Game
// 
// This class is used to set up the initial game
// and then get input from the user to control
// the game. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

@SuppressWarnings("serial")
public class Game extends JFrame implements ActionListener, MouseListener, MouseMotionListener{
	
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	
	private JButton pauseButton;
	private boolean isGamePaused;
	private Timer timer = new Timer(20, this);
	
	private TickCommand tickCommand = TickCommand.getInstance();
	private KittenCommand kittenCommand = KittenCommand.getInstance();
	private ContractCommand contractCommand = ContractCommand.getInstance();
	private DownCommand downCommand = DownCommand.getInstance();
	private ExpandCommand expandCommand = ExpandCommand.getInstance();
	private FightCommand fightCommand = FightCommand.getInstance();
	private LeftCommand leftCommand = LeftCommand.getInstance();
	private RightCommand rightCommand = RightCommand.getInstance();
	private ScoopCommand scoopCommand = ScoopCommand.getInstance();
	private HealCommand healCommand = HealCommand.getInstance();
	private UpCommand upCommand = UpCommand.getInstance();
	
	private Point curMouse = null;
	private Point startMouse = null;

	public Game() {
		gw = new GameWorld(); 	//OBSERVERABLE
		mv = new MapView(gw);
		sv = new ScoreView();
		gw.initLayout();
		guiSetup();
		gw.addObserver(mv);		//OBSERVER
		gw.addObserver(sv);		//OBSERVER
		gw.notifyObservers();
		
		resumeGame();
	}
	
	public boolean isPaused(){
		return isGamePaused;
	}
	
	public void pauseGame(){
		timer.stop();
		isGamePaused = true;
		gw.stopBackGroundClip();
		pauseButton.setText("Play");
		
		//ENABLE COMMANDS
		healCommand.setEnabled(true);
		
		//DISABLE COMMANDS
		contractCommand.setEnabled(false);
		downCommand.setEnabled(false);
		expandCommand.setEnabled(false);
		fightCommand.setEnabled(false);
		kittenCommand.setEnabled(false);
		leftCommand.setEnabled(false);
		rightCommand.setEnabled(false);
		scoopCommand.setEnabled(false);
		tickCommand.setEnabled(false);
		upCommand.setEnabled(false);
	}
	
	public void resumeGame(){
		timer.start();
		pauseButton.setText("Pause");
		isGamePaused = false;
		
		//PLAY SOUND
		if(gw.isSoundOn()){
			gw.playBackGroundClip();
		}
		
		//ENABLE COMMANDS
		contractCommand.setEnabled(true);
		downCommand.setEnabled(true);
		expandCommand.setEnabled(true);
		fightCommand.setEnabled(true);
		kittenCommand.setEnabled(true);
		leftCommand.setEnabled(true);
		rightCommand.setEnabled(true);
		scoopCommand.setEnabled(true);
		tickCommand.setEnabled(true);
		upCommand.setEnabled(true);
		
		//DISABLE COMMANDS
		healCommand.setEnabled(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		//INITIATE TICK
		tickCommand.actionPerformed(e);
	}
	
	public void mousePress(MouseEvent e){
		
	}
	
	public void guiSetup(){
		
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
		frame.setSize(860, 675);
		frame.setLocation(225,50);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(false);
		
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
//			JMenuItem kitten = new JMenuItem("Kiten"); 
//				kitten.setAction(KittenCommand.getInstance());	
//				commands.add(kitten);
//			JMenuItem fight = new JMenuItem("Fight"); 
//				fight.setAction(FightCommand.getInstance());	
//				commands.add(fight);
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
		JButton leftButton = new JButton ("Move Net Left"); 	
			leftButton.setAction(LeftCommand.getInstance());
			buttonPanel.add(leftButton);
		JButton rightButton = new JButton ("Move Net Right"); 
			rightButton.setAction(RightCommand.getInstance());
			buttonPanel.add(rightButton);
		JButton upButton = new JButton ("Move Net Up"); 	
			upButton.setAction(UpCommand.getInstance());
			buttonPanel.add(upButton);
		JButton downButton = new JButton ("Move Net Down"); 	
			downButton.setAction(DownCommand.getInstance());
			buttonPanel.add(downButton);
		JButton healButton = new JButton ("Heal"); 	
			healButton.setAction(HealCommand.getInstance());
			buttonPanel.add(healButton);
		pauseButton = new JButton ("Pause"); 	
			pauseButton.setAction(PauseCommand.getInstance());
			buttonPanel.add(pauseButton);
//			JButton kittenButton = new JButton ("New Kitten");
//				kittenButton.setAction(KittenCommand.getInstance());
//				buttonPanel.add(kittenButton);
//			JButton fightButton = new JButton ("Fight"); 	
//				fightButton.setAction(FightCommand.getInstance());
//				buttonPanel.add(fightButton);
//			JButton tickButton = new JButton ("Tick Clock"); 
//				tickButton.setAction(TickCommand.getInstance());
//				buttonPanel.add(tickButton);
		frame.add(buttonPanel, BorderLayout.WEST);
		
		//MAPVIEW SETUP
		mv = new MapView(gw);
		mv.addMouseListener(this);
		mv.addMouseMotionListener(this);
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
		SoundCommand.setTarget(gw);
		HealCommand.setTarget(gw);
		PauseCommand.setTarget(this);
		KittenCommand.setTarget(gw);
		FightCommand.setTarget(gw);
		TickCommand.setTarget(gw);	
		TickCommand.setInterval(timer.getDelay());
		
		frame.setVisible(true);
		frame.toFront();
	}

	public void mousePressed(MouseEvent e) {
		startMouse = e.getPoint();
		Point p = e.getPoint();
		
		IIterator iterator = gw.gObjects.getIterator();
		Object curObj;
		
		while(iterator.hasNext() && isPaused()){
			curObj = iterator.getNext();
			if(curObj instanceof Dog){
				if(((Dog)curObj).contains(p)){
					((Dog)curObj).setSelected(true);
				}
				else if( e.isControlDown()){
					((Dog)curObj).setSelected( ((Dog)curObj).isSelected() );
				}
				else{
					((Dog)curObj).setSelected(false);
				}
			}
		}
		mv.repaint();
	}
	
	public void mouseClicked(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}
	public void mouseDragged (MouseEvent e) {
		curMouse = e.getPoint(); 
		this.repaint();
		
//		Graphics g = this.getGraphics();
//		g.setColor(Color.YELLOW);
//		g.drawLine (startMouse.x, startMouse.y, curMouse.x, curMouse.y); 
//		startMouse = curMouse;
	}
	
	public void paintComponent(Graphics g) { 
		super.paintComponents(g);
		System.out.println("TEST");
		g.setColor (Color.YELLOW);
		if(startMouse != null && curMouse != null) {
			g.drawLine (startMouse.x, startMouse.y, curMouse.x, curMouse.y); 
		}
	}

	public void mouseMoved(MouseEvent e) {
		
	}
}
