package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*****************************************************************************
*
*  Name    :  Mick, Dante, Clifford
*  Date    :  4/18/15
****************************************************************************/
public class PlayerScoreRecord
{
    private static int winnings = 250;

    public static int getWinnings()
	{
	    return winnings;
	}

    public static void setWinnings(int winnings)
	{
	    PlayerScoreRecord.winnings = winnings;
	}

    public static void main(String[] args) throws IOException
	{
	    // an object out of class BufferedWriter is declared
	    BufferedWriter out = null;

	    {
		//writing the file
		FileWriter fstream = new FileWriter("PlayerScore.txt");
		out = new BufferedWriter(fstream);
		out.write("Total winnings $" + getWinnings());
		System.out.println("$" + getWinnings() + " added to your Bank Account!");

	    }
	    {
		if (out != null)
		{
		    out.close();
		}
	    }
	    BufferedReader in = null;
	    try
	    {
		FileReader fstream = new FileReader("PlayerScore.txt");
		in = new BufferedReader(fstream);
		String filetext = in.readLine();
		System.out.println("\nChecking your account... ");

		System.out.println(filetext);
	    } catch (IOException e)
	    {
		System.err.println("Error: " + e.getMessage());
	    }

	    {
		if (in != null)
		{
		    in.close();
		}
	    }
	}
}
