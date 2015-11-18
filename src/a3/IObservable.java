//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 2 of the Dog Catcher Game
// 
// This is the interface that implements
// that observer/observable design pattern. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a3;

public interface IObservable {
	public void addObserver(IObserver o);
	public void notifyObservers();
}
