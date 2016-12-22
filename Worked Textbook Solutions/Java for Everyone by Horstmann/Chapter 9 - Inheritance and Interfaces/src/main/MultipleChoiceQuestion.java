package main;

import java.util.ArrayList;

/**
 * Name: Mick Zeller
 * Worked Solutions from the textbook:  Java for Everyone by Cay Horstmann (Chapter 9 Inheritance and Interfaces)
 */
public class MultipleChoiceQuestion extends Question
{
    private ArrayList<String> answers;
    private String[] responses;


    public MultipleChoiceQuestion()
        {
        answers = new ArrayList<>();
        }

    @Override
    public void setAnswer(String correctResponse)
        {
        answers.add(correctResponse);
        }

    @Override
    public boolean checkAnswer(String response)
        {
        responses = response.split(" ");
        int correctCount = 0;
        looper:
        for (String check : answers)
            {
            for (int i = 0; i < responses.length; i++)
                {
                if (responses[i].equalsIgnoreCase(check))
                    {
                    correctCount++;
                    }
                }
            }
        return correctCount == answers.size();
        }

}
