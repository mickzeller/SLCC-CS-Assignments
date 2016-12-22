package main;

import java.util.Scanner;

/**
 * Name: Mick Zeller
 * Worked Solutions from the textbook:  Java for Everyone by Cay Horstmann (Chapter 9 Inheritance and Interfaces)
 */
public class FillInQuestion extends Question
{
    String question, answer;

    public FillInQuestion()
        {
            question = "";
            answer = "";
        }

    @Override
    public void setText(String questionText)
        {
        Scanner parser = new Scanner(questionText);
        parser.useDelimiter("_");
        question = parser.next();
        answer = parser.next();
        question += "_____";
        parser.close();

        super.setText(question);
        super.setAnswer(answer);

        }
}
