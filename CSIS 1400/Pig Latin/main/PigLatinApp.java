package main;

import java.util.Scanner;

/**
 * Name: Mick Zeller
 */
public class PigLatinApp
{

    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        String englishWord = "";

        System.out.println("Welcome to the Pig Latin Translator!\n");
        System.out.println("Please enter a word: ");
        englishWord = input.nextLine();
        System.out.println("The translation is " + pigLatin(englishWord));

        while (true)
        {
            System.out.println("Enter another word to be translated (or press Q to quit): ");
            englishWord = input.nextLine();

            if (englishWord.toLowerCase().startsWith("q"))
            {
                System.out.println("Have a great ayday!");
                System.exit(0);
            }
            System.out.println("The translation is " + pigLatin(englishWord));
        }
    }

    private static String pigLatin(String word)
    {
        word = word.toLowerCase();
        char letter = word.charAt(0);

        if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' || letter == 'y')
        {
            return word + "way";
        }

        for (int i = 0; i < word.length(); i++)
        {
            letter = word.charAt(i);

            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' || letter == 'y')
            {
                return word.substring(i, word.length()) + word.substring(0, i) + "ay";
            }

        }

        return null;
    }

}
