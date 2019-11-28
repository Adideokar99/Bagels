/*
* Bagels.java
* Author: Aditya Deokar
* Submission Date: 11/07/17
*
* Purpose: Runner Class that uses Player, Engine, and Validator Classes to run a guessing game.
*
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on a programming project created by the Department of
* Computer Science at the University of Georgia. Any publishing
* of source code for this project is strictly prohibited without
* written consent from the Department of Computer Science.
*/
import java.util.Scanner;
public class Bagels 
{
	public static void main(String [] args)
	{
		String name = "";
		String guess = "";
		String end = "";
		boolean playAgain = true;
		boolean result = false;
		boolean reset = true;
		int numDigits = 0;
		int fastestWin;
		int [] secret;
		Scanner keyboard = new Scanner(System.in);
		Scanner keyboard2 = new Scanner(System.in);
		
		// 
		System.out.println("Welcome!");
		
		while (reset)
		{
			System.out.print("Enter the number of digits to use: ");
			numDigits = keyboard.nextInt();
			
			System.out.print("Enter the player's name: ");
			name = keyboard2.nextLine();
			System.out.println();
			
			Player player1 = new Player();
			Engine thomas = new Engine();
			player1.setName(name);
			thomas.setNumDigits(numDigits);
			playAgain = true;
			
			// loop to control how many games are played
			while(playAgain)
			{
				thomas.generateNewSecret();
				secret = thomas.getSecretNumber();
				System.out.println("Starting game #" + (player1.getGamesCompleted() + 1) + ".");
				int guesses = 0;
				result = false;
				// reflects on the guesses made
				while(result != true)
				{
					guess = player1.askForGuess();
					result = Validator.validateGuess(secret, thomas.convertNumToDigitArray(guess), numDigits);
					guesses++;
				}
				player1.updateStats(guesses);
				fastestWin = player1.getFastestWin();
				System.out.println("Congratulations! You won in " + guesses + " moves.");
				System.out.println("");
				System.out.println("Statistics for " + name);
				System.out.println("Games Completed: " + player1.getGamesCompleted());
				System.out.println("Number of Digits: " + numDigits);
				System.out.println("Fastest Win: " + fastestWin + " guesses");
				System.out.println("p - Play again");
				System.out.println("r - ResetGame");
				System.out.println("q - Quit");
				
				System.out.println();
				
				System.out.print("What would you like to do? ");
				end = keyboard2.nextLine();
				
				if (end.equalsIgnoreCase("p"))
				{
					playAgain = true;
					reset = false;
				}
				
				// creates new engine and player objects which resets all the instance variables
				else if (end.equalsIgnoreCase("r"))
				{
					playAgain = false;
					thomas = new Engine();
					player1 = new Player();
					reset = true;
				}
				
				else 
				{
					playAgain = false;
					System.out.println("Goodbye!");
					reset = false;
				}
				
				System.out.println();
				System.out.println();
			}
		}
	}
}
