package exceptionHandling;

/********************************************************
 *
 *  Project :  Lab Exception Handling
 *  File    :  LabExceptionHandling.java
 *  Name    :  Mick Zeller
 *  Date    :  April 4, 2015
 *
 ********************************************************/


import java.util.InputMismatchException;
import java.util.Scanner;

public class LabExceptionHandling
{

    public static void main(String[] args)
	{
	    try
	    {
		int digit = numberFromUser();
		int result = sevenModulusN(digit);
		System.out.printf("7 %% %d = %d", digit, result);
	    } catch (Exception e)
	    {
		System.out.print("Nooooo! There is a problem! ");
		System.out.println(e.getMessage());
	    }
	}

    private static int numberFromUser()
	{
	    Scanner input = new Scanner(System.in);
	    boolean done = false;
	    int number = 1;
	    do
	    {
		try
		{
		    System.out.print("Please enter a number: ");
		    number = input.nextInt();
		    done = true;

		} catch (InputMismatchException e)
		{
		    System.out.println("Please only enter a whole number.");
		    input.nextLine();
		}

	    } while (!done);
	    input.close();
	    return number;
	}

    private static int sevenModulusN(int number)
	{
	    if (number == 0)
	    {
		throw new IllegalArgumentException("Unable to calculate 7 % 0");
	    }
	    return 7 % number;
	}
}
