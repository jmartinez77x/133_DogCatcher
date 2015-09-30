/* Joe Martinez
 * Fall 2015 CSC 133
 * Assignment 1 of the Dog Catcher Game
 * 
 * WHAT IS THIS FILE???
*/

package a1;
import java.util.Scanner;

public class Game{
	private GameWorld gw;
	private Scanner in; 
	
	
	public Game(){
		gw = new GameWorld();
		gw.initLayout();
		in = new Scanner(System.in);
		play();
		in.close();
	}
	
	
	//CODE TO ACCEPT AND EXECUTE USER COMMANDS THAT OPERATE ON THE GAMEWORLD
	private void play(){
		String command;
		
		while(true){
			command = getCommand();
			
			switch(command){
			case "e":	gw.expandNet();//EXPAND SIZE OF NET
			case "c":	gw.contractNet();//CONTRACT SIZE OF NET
			case "s":	gw.scoop();//SCOOP UP ANIMALS IN NET
			case "r":	gw.netRight();//MOVE NET RIGHT
			case "l":	gw.netLeft();//MOVE NET LEFT
			case "u":	gw.netUp();//MOVE NET UP 
			case "d":	gw.netDown();//MOVE NET DOWN
			case "k":	gw.catCollision();//PRETEND COLLISION BETWEEN TWO CATS...FOR LATER USE
			case "f":	gw.fightCollision();//PRETEND FIGHT OCCURS (CAT AND DOG COLLISION)...EDITED IN LATER EDITIONS	
			case "t":	gw.tickClock();//THE GAME CLOCK HAS "TICKED". UPDATE POSITIONS
			case "p":	gw.printPoints();//PRINT POINTS
			case "m":	gw.printMap();//PRINT A MAP OF CURRENT WORLD STATE
			case "q":	gw.quitGame();//QUIT (SYSTEM.EXIT(0))
			default:	//DEFAULT
			}
		}
	}
	
	
	private String getCommand(){
		String input; 
		
		System.out.print("Enter a single-character command: ");
		
		//TEST FOR VALID SINGLE-CHARACTER INPUT
		while(true){
			input = in.nextLine();
			
			if(input.length() == 0){
				System.out.print("Enter a single-character command: ");
				continue;
			}
			else if(input.length() != 0){
				if(input.length() > 1){
					System.out.print("Enter a single-character command: ");
					continue; 
				}else if(input.matches("e|c|s|r|l|u|d|k|f|t|p|m|q")){
					break;
				}
				else{
					System.out.print("Enter a single-character command: ");
					continue; 
				}
			}
		}
		
		//SWITCH STATEMENT FOR INPUT
		switch(input){
			case "e":	return "e";	//EXPAND SIZE OF NET
			case "c":	return "c";	//CONTRACT SIZE OF NET
			case "s":	return "s";	//SCOOP UP ANIMALS IN NET
			case "r":	return "r";	//MOVE NET RIGHT
			case "l":	return "l";	//MOVE NET LEFT
			case "u":	return "u";	//MOVE NET UP 
			case "d":	return "d";	//MOVE NET DOWN
			case "k":	return "k";	//PRETEND COLLISION BETWEEN TWO CATS...FOR LATER USE
			case "f":	return "f";	//PRETEND FIGHT OCCURS (CAT AND DOG COLLISION)...EDITED IN LATER EDITIONS	
			case "t":	return "t";	//THE GAME CLOCK HAS "TICKED". UPDATE POSITIONS
			case "p":	return "p";	//PRINT POINTS
			case "m":	return "m";	//PRINT A MAP OF CURRENT WORLD STATE
			case "q":	return "q";	//QUIT (SYSTEM.EXIT(0))
			default:	return "";	//DEFAULT
		}
	}
}
