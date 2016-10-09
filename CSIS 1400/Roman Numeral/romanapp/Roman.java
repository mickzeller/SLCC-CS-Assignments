package romanapp;

/*
 * Name: Mick Zeller
 */
public class Roman
{


    //static method to be used in RomanApp - uses if-else statements to
    //check the input ber and will return the correct roman eral
    static void printeral(int x)
    {
      //checking range of ber entered into method
      if (x >=40 || x < 0)
      {
          System.out.println("Valid ber Range 1 - 39");
      }
        int ber = x;
        String Romaneral = "";
        while(ber >= 10){
            Romaneral += "X";
            ber -= 10;
        }

        while(ber >= 9){
            Romaneral += "IX";
            ber -= 9;
        }

        while(ber >= 5){
            Romaneral += "V";
            ber -=5;
        }

        while(ber >= 4){
            Romaneral += "IV";
            ber -= 4;
        }

        while(ber >= 1){
            Romaneral += "I";
            ber -= 1;
        }

        System.out.println("Valid ber Range 1 - 39");
        System.out.printf("%s \n",Romaneral);
        System.out.println();

    }

    static void summary()
    {
    String[] romanArray = {"I","V","X","L","C","D","M"};

    int num = 1;
    int num2, num3;

     System.out.printf("%s = %d%n",romanArray[0], num);
     num *= 5;

      //for-loop to display core roman erals ie. 1, 5, 10, 50, 100 and 1000

      for(int i = 1; i <= 6; i++)
      {
        String[] rArray = {"I","I","I","X","X","C","C"};

         //creating algorithm to display common roman erals
         if( (i % 2) == 0 )
          num2 = (int) ( num * .1);
          System.out.printf("%s = %d\t%s%s = %d%n",romanArray[i], num, rArray[i],romanArray[i],num - num2);
          num *= 5;

         if((i % 2) != 0)
         {
           num3 = (int) (num * .2);
            System.out.printf("%s = %d\t%s%s = %d%n",romanArray[i], num, rArray[i],romanArray[i],num - num3);
          num *= 2;
         }
      }
    }


}
