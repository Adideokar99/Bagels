/*
* Player.java
* Author: Aditya Deokar
* Submission Date: 11/07/17
*
* Purpose: Class that makes the player object for the bagels class to use.
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
import java.lang.*;
public class Player 
{
	private String name = "";
	private int fastestWin = Integer.MAX_VALUE;
	private int gamesCompleted = 0;
	
	Scanner keyboard = new Scanner(System.in);
	
	// method asks user for guess and stores user input in string s
	public String askForGuess()
	{
		System.out.print("Enter your guess: ");
		String s = keyboard.nextLine();
		return s;
	}
	
	// returns instance variable name
	public String getName()
	{
		return name;
	}
	
	//returns instance variable fastest win
	public int getFastestWin()
	{
		return fastestWin;
	}
	
	// returns instance variable gamesCompleted
	public int getGamesCompleted()
	{
		return gamesCompleted;
	}
	
	// string parameter that will be assigned to the name instance variable
	public void setName(String inName)
	{
		name = inName;
	}
	
	// int parameter that is set to instance variable fastestWin if it is less than it
	// also increases gamesplayed instance variable by 1
	public void updateStats(int numberOfMovesTakenToWin)
	{
		if (numberOfMovesTakenToWin < fastestWin)
		{
			fastestWin = numberOfMovesTakenToWin;
		}
		
		gamesCompleted++;
	}
}

