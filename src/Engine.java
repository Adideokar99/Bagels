/*
* Engine.java
* Author: Aditya Deokar
* Submission Date: 11/07/17
*
* Purpose: Class that makes engine object for bagels class to use.
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
import java.util.Random;
import static java.lang.Math.pow;
public class Engine 
{
	private int numDigits = 0;
	private int [] secretNumber;
	
	Random randomNumberGenerator = new Random();
	
	// string number parameter that is converted into an array and returned
	public int [] convertNumToDigitArray(String number)
	{
		int [] array;
		
		for (int i = 0; i < number.length();)
		{
			if (number.substring(i, i + 1).equals("0"))
			{
				number = number.substring(i + 1);
			}
			
			else
			{
				break;
			}
		}
		array = new int [number.length()];
		for (int i = 0; i < number.length(); i++)
		{
			array [i] = Integer.parseInt(number.substring(i, i + 1));
		}
		
		return array;
	}
	
	// return num digits instance variable
	public int getNumDigits()
	{
		return numDigits;
	}
	
	// return secretNumber variable
	public int [] getSecretNumber()
	{
		return secretNumber;
	}
	
	// generates new secret number
	public void generateNewSecret()
	{
		randomNumberGenerator = new Random();
		int b = numDigits;
		
		double upperBound = pow(10, b) - 1;
		double lowerBound = pow(10, b - 1);
		int bound = (int)(upperBound - lowerBound);
		int temp = (int)(randomNumberGenerator.nextInt(bound) + lowerBound);
		String strTemp = Integer.toString(temp);
		secretNumber = convertNumToDigitArray(strTemp);
	}
	
	// assigns int array parameter to secretNumber instance variable
	public void setSecretNumber(int [] inSecretNumber)
	{
		this.secretNumber = inSecretNumber;
	}
	
	// assigns int parametr to num digits instance variable
	public void setNumDigits(int inNumDigits)
	{
		numDigits = inNumDigits;
	}
}