//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 1 of the Dog Catcher Game
// 
// This class is used to set up the initial game
// and then get input from the user to control
// the game. 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a1;

import java.util.Scanner;

public class Game {
	private GameWorld gw;
	private Scanner in;

	public Game() {
		gw = new GameWorld();
		gw.initLayout();
		in = new Scanner(System.in);
		play();
		in.close();
	}

	// CODE TO ACCEPT AND EXECUTE USER COMMANDS THAT OPERATE ON THE GAMEWORLD
	private void play() {
		String command;

		while (true) {
			command = getCommand();

			switch (command) {
			case "e":
				System.out.println("EXPANDING NET");
				gw.expandNet();
				break;// EXPAND SIZE OF NET
			case "c":
				System.out.println("CONTRACTING NET");
				gw.contractNet();
				break;// CONTRACT SIZE OF NET
			case "s":
				System.out.println("SCOOPING NET");
				gw.scoop();
				break;// SCOOP UP ANIMALS IN NET
			case "r":
				System.out.println("MOVING NET RIGHT");
				gw.netRight();
				break;// MOVE NET RIGHT
			case "l":
				System.out.println("MOVING NET LEFT");
				gw.netLeft();
				break;// MOVE NET LEFT
			case "u":
				System.out.println("MOVING NET UP");
				gw.netUp();
				break;// MOVE NET UP
			case "d":
				System.out.println("MOVING NET DOWN");
				gw.netDown();
				break;// MOVE NET DOWN
			case "k":
				System.out.println("CAT COLLISION");
				gw.catCollision();
				break;// PRETEND COLLISION BETWEEN TWO CATS...FOR LATER USE
			case "f":
				System.out.println("FIGHT COLLISION");
				gw.fightCollision();
				break;// PRETEND FIGHT OCCURS (CAT AND DOG COLLISION)...EDITED
						// IN LATER EDITIONS
			case "t":
				System.out.println("ADVANCED GAME CLOCK");
				gw.tickClock();
				break;// THE GAME CLOCK HAS "TICKED". UPDATE POSITIONS
			case "p":
				System.out.println("PRINTING POINTS");
				gw.printPoints();
				break;// PRINT POINTS
			case "m":
				System.out.println("PRINTING MAP");
				gw.printMap();
				break;// PRINT A MAP OF CURRENT WORLD STATE
			case "q":
				System.out.println("QUITTING GAME");
				gw.quitGame();
				break;// QUIT (SYSTEM.EXIT(0))
			default: // DEFAULT
			}
		}
	}

	private String getCommand() {
		String input;

		System.out.print("Enter a single-character command: ");

		// TEST FOR VALID SINGLE-CHARACTER INPUT
		while (true) {
			input = in.nextLine();

			if (input.length() == 0) {
				System.out.print("Enter a valid single-character command: ");
				continue;
			} else if (input.length() != 0) {
				if (input.length() > 1) {
					System.out
							.print("Enter a valid single-character command: ");
					continue;
				} else if (input.matches("e|c|s|r|l|u|d|k|f|t|p|m|q")) {
					break;
				} else {
					System.out
							.print("Enter a valid single-character command: ");
					continue;
				}
			}
		}

		// SWITCH STATEMENT FOR INPUT
		switch (input) {
		case "e":
			return "e"; // EXPAND SIZE OF NET
		case "c":
			return "c"; // CONTRACT SIZE OF NET
		case "s":
			return "s"; // SCOOP UP ANIMALS IN NET
		case "r":
			return "r"; // MOVE NET RIGHT
		case "l":
			return "l"; // MOVE NET LEFT
		case "u":
			return "u"; // MOVE NET UP
		case "d":
			return "d"; // MOVE NET DOWN
		case "k":
			return "k"; // PRETEND COLLISION BETWEEN TWO CATS...FOR LATER USE
		case "f":
			return "f"; // PRETEND FIGHT OCCURS (CAT AND DOG COLLISION)...EDITED
						// IN LATER EDITIONS
		case "t":
			return "t"; // THE GAME CLOCK HAS "TICKED". UPDATE POSITIONS
		case "p":
			return "p"; // PRINT POINTS
		case "m":
			return "m"; // PRINT A MAP OF CURRENT WORLD STATE
		case "q":
			return "q"; // QUIT (SYSTEM.EXIT(0))
		default:
			return ""; // DEFAULT
		}
	}
}
