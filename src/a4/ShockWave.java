//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Dog Catcher Game
// 
// The shock wave is a visual side effect of 
// scooping the net. It is a curve that
// travels through the game world for a short 
// amount of time. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a4;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.text.DecimalFormat;
import java.util.Vector;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ShockWave extends Animal{
	
	private final static int LIFESPAN = 1500;
	private final static int SPEED = 10;
	private final static int LEVEL = 7;
	private final static float EPSILON = (float)0.001;
	private int curLifeSpan;
	Vector pointVector = new Vector();
	
	ShockWave(float x, float y){
		setLocation(x, y);
		setSpeed(SPEED);
		curLifeSpan = LIFESPAN;
		initPoints();
	}
	
	private void initPoints(){
		if(pointVector.isEmpty()){
			pointVector.add(new ControlPoint(getXLoc() - rand.nextInt(100-20)+20*-1, getYLoc() - rand.nextInt(100-20)+20*-1));
			pointVector.add(new ControlPoint(getXLoc() + rand.nextInt(100-20)+20*-1, getYLoc() + rand.nextInt(100-20)+20));
			pointVector.add(new ControlPoint(getXLoc() - rand.nextInt(100-20)+20, getYLoc()    + rand.nextInt(100-20)+20));
			pointVector.add(new ControlPoint(getXLoc() + rand.nextInt(100-20)+20, getYLoc()    - rand.nextInt(100-20)+20*-1));
		}
	}
	
	public void move(int ms){
		//super.move(ms);
		curLifeSpan -= ms;
		
		float x = getXLoc();
		float y = getYLoc();
		float dx;
		float dy;

		dx = (float) Math.cos(90 - getXLoc()) * SPEED/2;
		dy = (float) Math.sin(90 - getYLoc()) * SPEED/2;
		
		dx = dx * ((float) ms/16);
		dy = dy * ((float) ms/16);

		x = x + dx; // NEW X LOCATION
		y = y + dy; // NEW Y LOCATION
		
		super.move(dx, dy);
	}
	
	public boolean expired(){
		return (curLifeSpan <= 0);
	}
	
	private void drawCurve(Graphics2D twoD, Vector points, int level){
		if(isStraight(points)  || (level > LEVEL) ){
			twoD.setColor(getColor());
			twoD.drawLine( (int)((ControlPoint)points.elementAt(0)).getX(), (int)((ControlPoint)points.elementAt(0)).getY(),
						  (int)((ControlPoint)points.elementAt(3)).getX(), (int)((ControlPoint)points.elementAt(3)).getY());
		} else{
			Vector leftPoints = new Vector(), rightPoints = new Vector();
			subCurve(points, leftPoints, rightPoints);
			drawCurve(twoD, leftPoints, level+1);
			drawCurve(twoD, rightPoints, level+1);
		}
	}
	
	private void subCurve(Vector points, Vector leftVector, Vector rightVector){
		ControlPoint l0, l1, l2, l3, r0, r1, r2, r3;
		
		l0 = new ControlPoint( ((ControlPoint)points.elementAt(0)) );
		
		l1 = new ControlPoint( ((((ControlPoint)points.elementAt(0)).getX() + ((ControlPoint)points.elementAt(1)).getX()) / 2), 
							   ((((ControlPoint)points.elementAt(0)).getY() + ((ControlPoint)points.elementAt(1)).getY()) / 2));
		
		l2 = new ControlPoint( (l1.getX()/2) + ((((ControlPoint)points.elementAt(1)).getX() + ((ControlPoint)points.elementAt(2)).getX()) / 4), 
							   (l1.getY()/2) + ((((ControlPoint)points.elementAt(1)).getY() + ((ControlPoint)points.elementAt(2)).getY()) / 4));
		
		r3 = new ControlPoint( ((ControlPoint)points.elementAt(3)) );
		
		r2 = new ControlPoint( ((((ControlPoint)points.elementAt(2)).getX() + ((ControlPoint)points.elementAt(3)).getX()) / 2), 
				   			   ((((ControlPoint)points.elementAt(2)).getY() + ((ControlPoint)points.elementAt(3)).getY()) / 2));
		
		r1 = new ControlPoint( (r2.getX()/2) + ((((ControlPoint)points.elementAt(1)).getX() + ((ControlPoint)points.elementAt(2)).getX()) / 4), 
				   			   (r2.getY()/2) + ((((ControlPoint)points.elementAt(1)).getY() + ((ControlPoint)points.elementAt(2)).getY()) / 4));
		
		l3 = new ControlPoint( ( (l2.getX() + r1.getX()) / 2), ( (l2.getY() + r1.getY()) / 2) );
		
		r0 = new ControlPoint( l3 );
		
		leftVector.add(l0);
		leftVector.add(l1);
		leftVector.add(l2);
		leftVector.add(l3);
		
		rightVector.add(r0);
		rightVector.add(r1);
		rightVector.add(r2);
		rightVector.add(r3);
	}
	
	private boolean isStraight(Vector points){
		float d1, d2;

		d1 = length( ((ControlPoint)points.elementAt(0)), (((ControlPoint)points.elementAt(1))) )
		   + length( ((ControlPoint)points.elementAt(1)), (((ControlPoint)points.elementAt(2))) )
		   + length( ((ControlPoint)points.elementAt(2)), (((ControlPoint)points.elementAt(3))) );
		
		d2 = length( ((ControlPoint)points.elementAt(0)), (((ControlPoint)points.elementAt(3))) );
		
		if( Math.abs(d1-d2) < EPSILON )
			return true;
		else
			return false;
	}
	
	private float length(ControlPoint p1, ControlPoint p2){
		float len, xD, yD;
		
		xD = p2.getX() - p1.getX();
		yD = p2.getY() - p1.getY();
		
		len =  (float)Math.sqrt( (Math.pow(xD, 2) + Math.pow(yD, 2)) );
		
		return len;
	}
	
	public void draw(Graphics2D twoD) {
		AffineTransform prevAT = twoD.getTransform();
		
		twoD.transform(getTranslate());
		twoD.transform(getRotation());
		twoD.transform(getScale());
		
		twoD.setColor(getColor());
		drawCurve(twoD, pointVector, 1);
		
		twoD.setTransform(prevAT);
	}
	
	public void draw(Graphics g) {

	}
	
	//ALL BELOW FUNCTIONS ARE FOR COLLISION DETECTION WHICH ARE NOT NEEDED
	public void handleCollision(ICollider obj1, ICollider obj2, GameWorld gw) {
		
	}

	public String getType() {
		return null;
	}
	
	public int getLeft() {
		return 0;
	}

	public int getRight() {
		return 0;
	}

	public int getTop() {
		return 0;
	}

	public int getBottom() {
		return 0;
	}
	
	private class ControlPoint {
		private float x, y;
		
		ControlPoint(float xIn, float yIn){
			x = xIn;
			y = yIn;
			//System.out.println(x);
			//System.out.println(y);
		}
		
		ControlPoint(ControlPoint p){
			x = p.getX();
			y = p.getY();
		}
		
		public float getX(){
			return x;
		}
		
		public float getY(){
			return y;
		}
		
	}
}
