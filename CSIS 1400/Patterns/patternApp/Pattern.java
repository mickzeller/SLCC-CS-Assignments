package patternApp;
/*
 * Name: Mick Zeller
 */
public class Pattern
{
  public static void pattern1(int size)
  {
    /*a complete run of this for loop will print the whole pattern.  Each iteration
    of 'i' will print a row.  Each nested for loops will print a specific element
    in that row at that specific location*/
    for(int i = 0; i < size; i++)
    {
      //placing "o" before creating new for loop gives a vertical column unaffected by spacing
      System.out.print(i);
      //first nested for loop will print all spaces left of the triangle
      for(int j = 0; j < size - i; j++)
      {
        System.out.print(" ");
      }
      //printing the forward slashes after the correct amount of spacing.
      System.out.print("//");
      //for loop to determine the spacing within the triangle starting at 0 and going to
      //the user's choice
      for(int k = 0; k < i; k++)
      {
        System.out.print("  ");
      }
      //backslashes are then printed after the correct spacing
        System.out.printf(" \\\\.%n");
   }
      //this is where the code begins a new iteration of "i" a loop and has completed one row
  }
  public static void pattern2(int size)
  {
for(int l = 0; l < size; l++)
    {
        for(int m = 0; m < size - l; m++)
      {
        System.out.print(" ");
      }
      System.out.print(".//");
      //for loop of inner triangle spaces
      for(int n = 0; n < l; n++)
      {
        System.out.print("  ");
      }
      //backspaces printed after the correct spacing within the triangle
      System.out.print(" \\\\");
      //spaces for the right side of the triangle.  Space is important in order to have the right justified column of 'o'
     for(int o = 1; o < size - l; o++)
      {
       System.out.print(" ");
      }
      //placing the "o" at the end of the loop allows for a right justified column the row is then ended and the next iteration begins
       System.out.print("o\n");
  }
  }


  public static void pattern3(int size)
  {

      for(int i = 0; i < size; i++)
      {
      System.out.print("o");
      for(int j = 0; j < i; j++)
      {
      System.out.print(" ");
      }
      System.out.print("\\\\");
    for(int j = size; j > 0; j--)
    {
      System.out.print(" ");
    }
  System.out.println("//.");
   }
  }

  public static void pattern4(int size)
  {
         for(int i = 1; i < 5; i++)
        {

            for(int j = 1; j < i * 2; j++)
            {
                System.out.print("X ");
            }
            for(int k = 0; k <= 7 - i * 2; k++)
            {
            System.out.print(". ");
            }
            System.out.print(" | ");
            for(int l = 0; l < 8 - i * 2; l++)
            {
                System.out.print(". ");
            }
            for(int m = 1; m < i * 2; m++)
            {
                System.out.print("X ");
            }
            System.out.println();
        }

    }
}
