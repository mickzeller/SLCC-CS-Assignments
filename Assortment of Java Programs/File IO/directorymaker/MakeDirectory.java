package directorymaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/****************************************************************
 * MakeDirectory.java
 * Mick Zeller
 * 5/8/2017
 *
 * This program creates folders representing each calendar month.
 * Inside each of these folders a .txt file is created representing
 * the corresponding day.
 *
 * As a note - this is a ridiculously complicated way and
 * probably isn't the best approach to accomplish this task - bash/python
 * script would be a better language.
 *****************************************************************/
public class MakeDirectory
{
    private static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public static void main(String[] args)
    {


        for (int i = 0; i < months.length; i++)
        {
            System.out.println();
            boolean success = new File("months\\" + (i + 1) + " - " + months[i]).mkdirs();
            if (success == true)
            {
                System.out.println(months[i] + " directory was created");

                if (i == 1)
                {
                    for (int j = 1; j < 29; j++)
                    {
                        makeTextFile(i, String.valueOf(j));
                    }
                }
                if ((i % 2) != 0 && i != 1)
                {
                    for (int j = 1; j < 31; j++)
                    {
                        makeTextFile(i, String.valueOf(j));
                    }

                } else if ((i % 2) == 0)
                {
                    for (int j = 1; j < 32; j++)
                    {
                        makeTextFile(i, String.valueOf(j));
                    }
                }


            } else if (success != true)
            {
                System.out.println(months[i] + " directory was NOT created");
            }
        }
    }

    private static void makeTextFile(int month, String day)
    {
        //try with resources
        try (PrintWriter out = new PrintWriter(new File("months\\" + (month + 1) + " - " + months[month] + "\\" + months[month] + " " + day.concat(".txt"))))
        {

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }


}
