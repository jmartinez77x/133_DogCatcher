//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 
// Joe Martinez
// Fall 2015 CSC 133
// Assignment 1 of the Dog Catcher Game
// 
// This class is where most of the control takes place.
// This is where most data is instantiated and manipulated.
// It is also where most functions are performed or called.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\ 

package a1;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;
import java.util.Random;

public class GameWorld {
	private int gameClock;
	private int numOfCats; // INPUT FROM USER
	private int numOfDogs; // INPUT FROM USER
	private int catsCaptured;
	private int dogsCaptured;
	private int totalCats;
	private int totalDogs;
	private int totalPoints;
	private int totalScratches;

	private Scanner qIn;
	private String qInput;
	private Scanner initIn;
	private String initInput;

	private Net net;
	private Cat cat;
	private Dog dog;

	private ArrayList<Object> gObjects = new ArrayList<Object>();

	Random rand = new Random();

	// CODE TO CREATE THE INITIAL GAME OBJECTS/LAYOUTS
	public void initLayout() {

		initIn = new Scanner(System.in);

		// GET NUMBER OF CATS AND DOGS
		System.out.print("Enter an integer for number of cats: ");
		initInput = initIn.nextLine();
		numOfCats = Integer.parseInt(initInput);
		System.out.print("Enter an integer for number of dogs: ");
		initInput = initIn.nextLine();
		numOfDogs = Integer.parseInt(initInput);

		// TOTAL POINTS STARTS AT 0
		totalPoints = 0;
		totalCats = 0;
		totalDogs = 0;
		totalScratches = 0;

		// CREATE NET
		net = new Net();
		net.setSize(100);
		net.setColor(Color.RED);
		net.randLocation();
		gObjects.add(net);

		// CREATE CATS BASED ON NUMBER FROM USER
		for (int i = 0; i < numOfCats; i++) {
			cat = new Cat();
			cat.randSize();
			cat.setSpeed(5);
			cat.setColor(Color.GREEN);
			cat.randLocation();
			cat.randDirection();
			gObjects.add(cat);
			totalCats++;
		}

		// CREATE DOGS BASED ON NUMBER FROM USER
		for (int i = 0; i < numOfDogs; i++) {
			dog = new Dog();
			dog.randSize();
			dog.setSpeed(5);
			dog.setColor(Color.BLUE);
			dog.randLocation();
			dog.randDirection();
			gObjects.add(dog);
			totalDogs++;
		}
	}

	public void printMap() {
		for (int i = 0; i < gObjects.size(); i++) {
			// CALL EACH TO STRING TO PRINT INFORMATION
			System.out.println(gObjects.get(i).toString());
		}
	}

	public void expandNet() {
		net.expandNet();
	}

	public void contractNet() {
		net.contractNet();
	}

	public void scoop() {
		float netLeftB = net.getXLoc() - (net.getSize() / 2);
		float netRightB = net.getXLoc() + (net.getSize() / 2);
		float netBotB = net.getYLoc() - (net.getSize() / 2);
		float netTopB = net.getYLoc() + (net.getSize() / 2);

		for (int i = 0; i < gObjects.size(); i++) {
			if (gObjects.get(i) instanceof Cat) {
				// CHECK IF CAT IS WITHIN BOUNDARIES OF THE NET
				if ((((Cat) gObjects.get(i)).getXLoc() > netLeftB)
						&& (((Cat) gObjects.get(i)).getXLoc() < netRightB)
						&& (((Cat) gObjects.get(i)).getYLoc() > netBotB)
						&& (((Cat) gObjects.get(i)).getYLoc() < netTopB)) {
					System.out.println("CAT CAUGHT");

					catsCaptured++;
					totalCats--;

					gObjects.remove(i);
				}
			} else if (gObjects.get(i) instanceof Dog) {
				// CHECK IF DOG IS WITHIN BOUNDARIES OF THE NET
				if ((((Dog) gObjects.get(i)).getXLoc() > netLeftB)
						&& (((Dog) gObjects.get(i)).getXLoc() < netRightB)
						&& (((Dog) gObjects.get(i)).getYLoc() > netBotB)
						&& (((Dog) gObjects.get(i)).getYLoc() < netTopB)) {
					System.out.println("DOG CAUGHT");

					dogsCaptured++;
					totalDogs--;

					// REMOVE DOG --- GAME OVER IF ZERO DOGS
					gObjects.remove(i);
					if (totalDogs == 0) {
						System.out.println("*******GAME OVER*******");
						printPoints();
						System.exit(0);
					}
				}
			}
		}
	}

	public void netRight() {
		net.netRight();
	}

	public void netLeft() {
		net.netLeft();
	}

	public void netUp() {
		net.netUp();
	}

	public void netDown() {
		net.netDown();
	}

	// TWO CATS COLLIDE
	public void catCollision() {
		// IF NOT ENOUGH CATS TO MAKE KITTEN
		if (totalCats < 2) {
			System.out
					.println("Less than two cats in game - Cannot make kitten.");
		} else {
			float x = this.cat.getXLoc();
			float y = this.cat.getYLoc();
			cat = new Cat();
			cat.randSize();
			cat.setSpeed(5);
			cat.setColor(Color.GREEN);
			cat.randDirection();
			cat.setLocation(x + rand.nextFloat() * 10, y + rand.nextFloat()
					* 10);
			gObjects.add(cat);
			totalCats++;
		}
	}

	// CAT AND DOG COLLIDE
	public void fightCollision() {
		ArrayList<Integer> dogList = new ArrayList<Integer>();

		// IF NO CATS TO COLLIDE WITH
		if (totalCats == 0) {
			System.out.println("No cats in game - No scratch recorded");
		} else {
			for (int i = 0; i < gObjects.size(); i++) {
				if (gObjects.get(i) instanceof Dog) {
					dogList.add(i);
				}
			}
		}
		// RANDOM INTEGER BASED ON SIZE OF DOG LIST --- NEED THIS TO GET VALUE
		// FROM DOGLIST
		int randDog = rand.nextInt(dogList.size());
		// RANDOM POSITION VALUE FROM GOBJECT LIST
		int randPos = dogList.get(randDog);

		((Dog) gObjects.get(randPos)).incScratches();
		((Dog) gObjects.get(randPos)).incColor();
		((Dog) gObjects.get(randPos)).decSpeed();
	}

	public void tickClock() {
		gameClock = gameClock + 1;

		// MOVE EACH ANIMAL
		for (int i = 0; i < gObjects.size(); i++) {
			if (gObjects.get(i) instanceof Animal) {
				((Animal) gObjects.get(i)).move();
			}
		}
	}

	public void printPoints() {
		// TAKE AWAY ONE POINT FOR EACH SCRATCH
		// GET TOTAL AMOUNT OF SCRATCHES
		for (int i = 0; i < gObjects.size(); i++) {
			if (gObjects.get(i) instanceof Dog) {
				if (((Dog) gObjects.get(i)).getScratches() > 0) {
					totalScratches += (((Dog) gObjects.get(i)).getScratches());
					totalPoints += -1
							* (((Dog) gObjects.get(i)).getScratches());
				}
			}
		}

		totalPoints += catsCaptured * -10;// CAT = -10 POINTS
		totalPoints += dogsCaptured * 10; // UNSCRATCHED DOG = 10 POINTS

		System.out.println("Cats Captured:  " + catsCaptured); // CATS CAPTURED
		System.out.println("Dogs Captured:  " + dogsCaptured); // DOGS CAPTURED
		System.out.println("Cats Remaining: " + totalCats); // CATS REMAINING
		System.out.println("Dogs Remaining: " + totalDogs); // DOGS REMAINING
		System.out.println("Scratches:      " + totalScratches);// TOTAL
																// SCRATCHES
		System.out.println("TOTAL POINTS:   " + totalPoints); // TOTAL POINTS

		// RESET TOTAL POINTS
		totalPoints = 0;
		totalScratches = 0;
	}

	public void quitGame() {
		qIn = new Scanner(System.in);

		System.out.print("Are you sure you want to quit? Enter y/n: ");

		qInput = qIn.nextLine();
		qInput.toUpperCase();

		switch (qInput) {
		case "y":
			System.exit(0);
		case "Y":
			System.exit(0);
		default:
		}
	}
}