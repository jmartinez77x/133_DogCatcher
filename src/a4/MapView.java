//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Dog Catcher Game
// 
// This class sets up and updates the "MapView".
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.*;

@SuppressWarnings("serial")
public class MapView extends JPanel implements IObserver{
	
	private double winLeft, winRight, winTop, winBottom;
	private AffineTransform game_to_ND, nd_to_Screen, myVTM;
	private GameWorld gw;
	
	MapView(GameWorld game){
		setBackground(Color.gray);
		gw = game;
		winLeft = winBottom = 0; //SET BOTTOM LEFT TO (0,0)
		winRight = 700;
		winTop = 600;
	}
	
	public void update(IObservable o) {
//		//PRINT TEXT MAP IN CONSOLE
//		if(o instanceof GameWorld){
//			((GameWorld)o).printMap();
//		}
		repaint();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D twoD = (Graphics2D) g;
		AffineTransform save_AT = twoD.getTransform();
		
		double winHeight = winTop - winBottom;
		double winWidth = winRight - winLeft;
		
		game_to_ND = game_to_NDXTransform(winWidth, winHeight, winLeft, winBottom);
		nd_to_Screen = ndt_to_ScreenTransform((double)this.getWidth(), (double)this.getHeight());
		myVTM = (AffineTransform)nd_to_Screen.clone();
		myVTM.concatenate(game_to_ND);
		twoD.transform(myVTM);
		
		IIterator iterator = gw.gObjects.getIterator();
		Object curObj = new Object();
		
		while(iterator.hasNext() ){
			curObj = iterator.getNext();
			if(curObj != null){
				if((GameObject)curObj instanceof Net && gw.flashNet){
					((Net)(GameObject)curObj).flashNet(g);
					gw.flashNet = false;
				}
				if((GameObject)curObj instanceof ShockWave){
					((GameObject)curObj).draw(twoD);
				}
				else{
					((GameObject)curObj).draw(g);
				}
			}
		}
		setVisible(true);
		
		twoD.setTransform(save_AT);
	}

	private AffineTransform ndt_to_ScreenTransform(double pWidth, double pHeight) {
		AffineTransform transform = new AffineTransform();
		transform.translate(0, pHeight);
		transform.scale(pWidth, -pHeight);
		return transform;
	}
	private AffineTransform game_to_NDXTransform(double width, double height, double left, double bottom) {
		AffineTransform transform = new AffineTransform();
		transform.scale((1/width), (1/height));
		transform.translate(-left, -bottom);
		return transform;
	}
	
	// zooms in 5%
	public void zoomIn(){
		double h = winTop - winBottom;
		double w = winRight - winLeft;
		winLeft += w*0.05;
		winRight -= w*0.05;
		winTop -= h*0.05;
		winBottom += h*0.05;
		this.repaint();
	}
	
	// zooms out 5%
	public void zoomOut(){
		double h = winTop - winBottom;
		double w = winRight - winLeft;
		winLeft -= w*0.05;
		winRight += w*0.05;
		winTop += h*0.05;
		winBottom -= h*0.05;
		this.repaint();
	}
	
	public void panLeft(){
		winLeft += 5;
		winRight += 5;
	}
	
	public void panRight(){
		winLeft -= 5;
		winRight -= 5;
	}
	
	public void panUp(){
		winTop -= 5;
		winBottom -= 5;
	}
	
	public void panDown(){
		winTop += 5;
		winBottom += 5;
	}
	
	public AffineTransform getVTM(){
		return new AffineTransform(myVTM);
	}
	
	public int getWinWidth(){
		return (int)(winRight - winLeft);
	}
	
	public int getWinHeight(){
		return (int)(winTop - winBottom);
	}
}
