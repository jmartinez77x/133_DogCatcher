package a1;

public class Location{
	//PRIVATE DATA
	private float X;
	private float Y;
	
	//CONSTRUCT OBJECT
	Location(float x, float y){
		X = x;
		Y = y;
	}
	
	//GET X
	public float getX(){
		return X;
	}
	
	//GET Y
	public float getY(){
		return Y;
	}
	
	//SET X
	private void setX(float x){
		X = x;
	}
	
	//SET Y
	private void setY(float y){
		Y = y;
	}
	
	//SET X AND Y
	public void setXY(float x, float y){
		setX(x);
		setY(y);
	}
}
