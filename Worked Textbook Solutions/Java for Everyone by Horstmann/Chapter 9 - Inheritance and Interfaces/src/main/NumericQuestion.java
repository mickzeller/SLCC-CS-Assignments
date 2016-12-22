package main;

/**
 * Name: Mick Zeller
 * Worked Solutions from the textbook:  Java for Everyone by Cay Horstmann (Chapter 9 Inheritance and Interfaces)
 */
public class NumericQuestion extends Question
{

    private final double EPSILON = 0.1;
    private double answer;


    public void setAnswer(double correctResponse)
        {
        answer = correctResponse;
        }

    @Override
    public boolean checkAnswer(String response)
        {
        double responseDouble = Double.parseDouble(response);
        return Math.abs(responseDouble - answer) <= EPSILON;
        }
}
