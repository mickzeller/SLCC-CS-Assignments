package main;

import java.util.ArrayList;

/**
 * Name: Mick Zeller
 * Worked Solutions from the textbook:  Java for Everyone by Cay Horstmann (Chapter 9 Inheritance and Interfaces)
 */
public class QuestionDemo
{

    private static ArrayList<Question> quiz = new ArrayList<>();

    public static void main(String[] args)
        {

        Question question = new Question();
        question.setText("Who invented the programming language Java?");
        question.setAnswer("James Gosling");

        ChoiceQuestion choiceQuestion = new ChoiceQuestion();
        choiceQuestion.setText("What is the GREATEST programming language of all time?");
        choiceQuestion.addChoices("Assembly", false);
        choiceQuestion.addChoices("Perl", false);
        choiceQuestion.addChoices("Java", true);
        choiceQuestion.addChoices("Cold Fusion", false);

        NumericQuestion numericQuestion = new NumericQuestion();
        numericQuestion.setText("What is 1/4 in decimal form?");
        numericQuestion.setAnswer(.250);

        FillInQuestion fillInQuestion = new FillInQuestion();
        fillInQuestion.setText("The inventor of Java was _James Gosling_");

        AnyCorrectChoiceQuestion anyCorrectChoiceQuestion = new AnyCorrectChoiceQuestion();
        anyCorrectChoiceQuestion.setText("Type ANY correct programing languages - separated by spaces.\nJava\nApple\nC++\nPCP\nbasicCode");
        anyCorrectChoiceQuestion.setAnswer("Java");
        anyCorrectChoiceQuestion.setAnswer("C++");

        MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion();
        multipleChoiceQuestion.setText("Type ALL correct programing languages - separated by spaces.\nJava\nApple\nC++\nPCP\nbasicCode");
        multipleChoiceQuestion.setAnswer("Java");
        multipleChoiceQuestion.setAnswer("C++");

        quiz.add(question);
        quiz.add(choiceQuestion);
        quiz.add(numericQuestion);
        quiz.add(fillInQuestion);
        quiz.add(anyCorrectChoiceQuestion);
        quiz.add(multipleChoiceQuestion);

        quiz.forEach(Question::presentQuestion);


        }
}
