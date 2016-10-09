package patternApp;
/*
 * Name: Mick Zeller
 */
import java.util.Scanner;

public class PatternApp
{
  public static void main(String[] args)
  {
       Scanner input = new Scanner(System.in);
        int userChoice;
        int userSize;
      do{
        System.out.print("Please choose a number from 1-4 for a pattern. Type 0 to exit.");
        userChoice = input.nextInt();
        System.out.print("Size: ");
        userSize = input.nextInt();
        switch (userChoice)
        {
           case 1:
              Pattern.pattern1(userSize);
           break;

           case 2:
              Pattern.pattern2(userSize);
           break;

           case 3:
              Pattern.pattern3(userSize);
           break;

           case 4:
              Pattern.pattern4(userSize);
           break;

           default:
     System.out.println( "Giving up already are we?  OK\nHava a great day!" );
        break;
        }
     }while(userChoice != 0);
  }
}
