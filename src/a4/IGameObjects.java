//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Dog Catcher Game
// 
// This is an interface for all Game Objects.
// Used for the iterator design pattern. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a4;

public interface IGameObjects{
	public void add(Object newO);
	public IIterator getIterator();
}
