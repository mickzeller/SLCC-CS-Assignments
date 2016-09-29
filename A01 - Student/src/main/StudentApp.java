/********************************************************
 *
 * Project : Students| Assignment 1
 * Name : Mick Zeller 
 * Date : Jan 17, 2015
 *
 * Description : Creating an ArrayList for students of a given school
 * 
 *
 * 1) Will be used to find the size of the roll, add students, delete students
 * and find a certain student. Each student will also be given a unique ID
 * number
 *
 * 2) ArrayList will be the primary data structure.
 *
 * 3) Switch statement to cycle between the students. ArrayList to store the
 * information. Methods are provided on the Student Class.
 *
 ********************************************************/
package main;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentApp
{

    public static void main(String[] args)
	{

	    Student student1 = new Student("John", "Smith", "(CS)", 3.6);
	    Student student2 = new Student("Lauren", "Edwards", "(CS)", 3.8);
	    Student student3 = new Student("Alex", "Taylor", "(EE)", 3.2);

	    ArrayList<Student> classList = new ArrayList<Student>();

	    classList.add(student3);
	    classList.add(student2);
	    classList.add(student1);

	    System.out.println("Please select one of the menus items: ");

	    int userChoice;
	    System.out.println();
	    System.out.println(" 1. Add a student ");
	    System.out.println(" 2. Find a student ");
	    System.out.println(" 3. Delete a student ");
	    System.out.println(" 4. Display all students ");
	    System.out.println(" 5. Display the total number of students ");
	    System.out.println(" 6. Exit\n");
	    System.out.print(" Enter your selection: ");

	    do
	    {

		Scanner input = new Scanner(System.in);
		userChoice = input.nextInt();
		

		switch (userChoice)

		{

		    case 1:

			String studentFirstName, studentLastName, studentMajor;
			double studentGpa;

			System.out.println("\n***************ADDING STUDENT**************");

			System.out.print("First name and Last Name: ");
			studentFirstName = input.nextLine();
			System.out.println();

			studentLastName = input.nextLine();
			System.out.println();

			System.out.println("Major: ");
			studentMajor = input.nextLine();
			System.out.println();

			System.out.println("GPA: ");
			studentGpa = input.nextDouble();
			System.out.println();

			classList.add(new Student(studentFirstName, studentLastName, studentMajor, studentGpa));

			break;

		    case 2:

			System.out.println("\n***********FIND A STUDENT***********");

			System.out.print(classList.toString());

			System.out.print("\nFind Student with S Number: ");

			int studentNumber = input.nextInt();

			System.out.print(classList.indexOf((studentNumber)));

			break;

		    case 3:

			System.out.println("\n**************DELETE A STUDENT***************");
			System.out.println(classList);
			System.out.println("Choose a student to remove by entering a number: ");
			int remove = 1;
			remove = input.nextInt();
			classList.remove(remove);
			System.out.println(classList);

			break;

		    case 4:

			System.out.println("\n*****************DISPLAYING ALL STUDENTS******************");
			for(Student student : classList)
			{
			    System.out.println(student.toString());
			}

			break;

		    case 5:
			System.out.println("\n**************DISPLAYING TOTAL NUMBER OF STUDENTS*************");
			System.out.println(classList.size());
			break;

		    case 6:

			break;

		}

	    } while (userChoice != 6);
	}

}
