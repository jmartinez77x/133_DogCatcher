//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Dog Catcher Game
// 
// The creates and updates the "ScoreView"
// which shows the stats of the game. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a4;

import javax.swing.*;

@SuppressWarnings("serial")
public class ScoreView extends JPanel implements IObserver{

	private JLabel totalPoints;
	private JLabel catsCaptured;
	private JLabel dogsCaptured;
	private JLabel catsRemaining;
	private JLabel dogsRemaining;
	private JLabel sound;
	
	ScoreView(){
		totalPoints		= new JLabel ("   Total Points: -"  );	add(totalPoints);
		catsCaptured 	= new JLabel ("   Cats Captured: -" ); 	add(catsCaptured);
		dogsCaptured	= new JLabel ("   Dogs Captured: -" ); 	add(dogsCaptured);
		catsRemaining 	= new JLabel ("   Cats Remaining: -"); 	add(catsRemaining);
		dogsRemaining 	= new JLabel ("   Dogs Remaining: -"); 	add(dogsRemaining);
		sound 			= new JLabel ("   Sound: -"		    ); 	add(sound);
		
		this.setVisible(true);
	}
	
	public void update(IObservable o) {
		totalPoints.setText  ("   Total Points: "  + ((GameWorld) o).getTotalPoints());
		catsCaptured.setText ("   Cats Captured: " + ((GameWorld) o).getCatsCaptured());
		dogsCaptured.setText ("   Dogs Captured: " + ((GameWorld) o).getDogsCaptured());
		catsRemaining.setText("   Cats Remaining: "+ ((GameWorld) o).getCatsRemaining());
		dogsRemaining.setText("   Dogs Remaining: "+ ((GameWorld) o).getDogsRemaining());
		if(((GameWorld) o).isSoundOn()){
			sound.setText("   Sound: ON");
		}else{
			sound.setText("   Sound: OFF");
		}
		
		this.setVisible(true);	
	}
}
