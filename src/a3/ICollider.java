//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 2 of the Dog Catcher Game
// 
// This is an interface meant to handle 
// collision detection. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a3;

public interface ICollider {
	
	public boolean collidesWith(ICollider obj);
	public void handleCollision(ICollider obj1, ICollider obj2, GameWorld gw);
	
	public abstract String getType();
	
	public abstract int getLeft();
	public abstract int getRight();
	public abstract int getTop();
	public abstract int getBottom(); 
}