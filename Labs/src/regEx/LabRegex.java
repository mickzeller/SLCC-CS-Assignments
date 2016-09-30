package regEx;
/*
 * Name: Mick Zeller 
 * Date: April 29, 2015
 */

import java.util.Scanner;

public class LabRegex
{
    public static void main(String[] args)
	{
	    String myRegex1 = "CS\\d{4}";
	    test(myRegex1);
	    //words that start with an upper case A
	    String myRegex2 = "^[A]+\\w";
	    test(myRegex2);
	    //words that start with an upper case vowel (A, E, I, O U)
	    String myRegex3 = "^[AEIOU]+\\w";
	    test(myRegex3);
	    //words that start with an upper case vowel (A, E, I, O U) and are at least two characters long
	    String myRegex4 = "^[AEIOU]+{2}\\w";
	    test(myRegex4);
	    //regEx for a 7 or 10 digit number, with extensions allowed,
	    // delimiters are spaces, dashes, or periods
	    String myRegex5 = "^(?:(?:\\+?1\\s*(?:[.-]\\s*)?)?(?:" + "\\(\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8]"
		    + "[02-9])\\s*\\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9]"
		    + "[02-8][02-9]))\\s*(?:[.-]\\s*)?)?([2-9]1[02-9]"
		    + "|[2-9][02-9]1|[2-9][02-9]{2})\\s*(?:[.-]\\s*)?"
		    + "([0-9]{4})(?:\\s*(?:#|x\\.?|ext\\.?|extension)" + "\\s*(\\d+))?$";
	    test(myRegex5);
	    //match email's
	    String myRegex6 = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
	    test(myRegex6);
	}

    private static void test(String regex)
	{
	    String word;
	    Scanner input = new Scanner(System.in);

	    System.out.printf("Enter words to match the expression %s%n", regex);
	    System.out.println("Enter DONE when you are finished");
	    System.out.print("Word: ");
	    word = input.nextLine();

	    while (!word.equalsIgnoreCase("done"))
	    {
		System.out.printf("%s %s%n", word, word.matches(regex) ? "matches" : "does not match");
		System.out.print("Word: ");
		word = input.nextLine();
	    }
	}
}