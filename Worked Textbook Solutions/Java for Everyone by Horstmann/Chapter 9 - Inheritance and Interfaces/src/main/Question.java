package main;

import java.util.Scanner;

/**
 * Name: Mick Zeller
 * Worked Solutions from the textbook:  Java for Everyone by Cay Horstmann (Chapter 9 Inheritance and Interfaces)
 */
public class Question
{
    private String text, answer;

    public Question()
        {
        text = "";
        answer = "";
        }

    public void setText(String questionText)
        {
        text = questionText;
        }

    public void setAnswer(String correctResponse)
        {
        answer = correctResponse;
        }

    public boolean checkAnswer(String response)
        {
        return response.equalsIgnoreCase(answer);
        }

    public void display()
        {
        System.out.println(text);
        }

    public void presentQuestion()
        {
        this.display();
        System.out.println("Your Answer: ");
        Scanner in = new Scanner(System.in);
        String response = in.nextLine();
        System.out.println(this.checkAnswer(response));
        }

}
