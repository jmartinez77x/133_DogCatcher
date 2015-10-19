//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 2 of the Dog Catcher Game
// 
// This class handles the collection of game
// objects and the iterator to move through
// the list of them. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a2;

import java.util.ArrayList;

public class GameObjectCollection implements IGameObjects{
	private ArrayList<Object> gObjects;
	
	GameObjectCollection(){
		gObjects = new ArrayList<Object>();
	}

	public void add(Object newO) {
		gObjects.add(newO);
	}

	public IIterator getIterator() {
		return new GameObjectIterator();
	}
	
	public boolean remove(Object o){
		return gObjects.remove(o);
	}
	
	private class GameObjectIterator implements IIterator{
		private int index;
		
		public GameObjectIterator(){
			index = -1;
		}
		
		public boolean hasNext() {
			if(gObjects.size() < 1){
				return false;
			}
			if(index == gObjects.size() - 1){
				return false;
			}
			return true; 
		}

		public Object getNext() {
			index++;
			return gObjects.get(index);
		}

		public void remove() {
			gObjects.remove(index);
		}
		
		public int getIndex(){
			return index; 
		}
		
		public Object objectAt(int i){
			return gObjects.get(i);
		}
	}
}
