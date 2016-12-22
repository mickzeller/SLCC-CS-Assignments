package main;

import java.util.ArrayList;

/**
 * Name: Mick Zeller
 * Worked Solutions from the textbook:  Java for Everyone by Cay Horstmann (Chapter 9 Inheritance and Interfaces)
 */
public class ChoiceQuestion extends Question
{
    private ArrayList<String> choices;


    public ChoiceQuestion()
        {
        choices = new ArrayList<>();
        }

    public void addChoices(String choice, boolean correct)
        {
        choices.add(choice);
        if (correct)
            {
                    /* if correct convert choices.size() to String */
            String choiceString = "" + choices.size();
            setAnswer(choiceString);
            }
        }

    public void display()
        {
            /* Displaying the question */
        super.display();
        int questionNumber = 0;
            /* Displaying all possible answers */
        for (String questions : choices)
            {
            System.out.println((questionNumber + 1) + ": " + questions);
            questionNumber++;
            }
        }


}
