//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Dog Catcher Game
// 
// This is the iterator interface for game objects.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a3;

public interface IIterator{
	public boolean hasNext();
	public Object getNext();
	public void remove();
	
	public int getIndex();
	public Object objectAt(int i);
}
