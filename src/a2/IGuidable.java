//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 2 of the Dog Catcher Game
// 
// This interface will handle all guiding functions.
// This is used by the Catcher class.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a2;

public interface IGuidable {

	public void expandNet();
	public void contractNet();
	public void scoop();
	public void netRight();
	public void netLeft();
	public void netUp();
	public void netDown();
}
