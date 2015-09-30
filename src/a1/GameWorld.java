/* Joe Martinez
 * Fall 2015 CSC 133
 * Assignment 1 of the Dog Catcher Game
 * 
 * WHAT IS THIS FILE???
*/

package a1;
import java.util.ArrayList;

public class GameWorld {
	private int gHeight;
	private int gWidth; 
	ArrayList<Object> gObjects = new ArrayList<Object>();
	
	//CODE TO CREATE THE INITIAL GAME OBJECTS/LAYOUTS
	public void initLayout(){
		gHeight = 1024;
		gWidth = 1024;
		
		Net net = new Net();
		
		Cat cat1 = new Cat();
		Cat cat2 = new Cat(); 
		Cat cat3 = new Cat();
		
		Dog dog1 = new Dog();
		Dog dog2 = new Dog();
		Dog dog3 = new Dog();
		
		gObjects.add(net);
		gObjects.add(cat1);
		gObjects.add(cat2);
		gObjects.add(cat3);
		gObjects.add(dog1);
		gObjects.add(dog2);
		gObjects.add(dog3);
	
	}
	//METHODS TO MANIPULATE WORLD OBJECTS AND REALTED GAME STATE DATA
	public int getHeight(){
		return gHeight;
	}
	public int getWidth(){
		return gWidth;
	}public void printMap(){
		Object obj = new Object();
		for(int i = 0; i < gObjects.size(); i++){
			obj = gObjects.get(i);
			System.out.println(obj.toString());
		}
	}
}