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

/**
 * The Class Student.
 */
public class Student
{

    public String firstName;
    private String lastName;
    private String major;
    private int sNumber;
    private static int count;
    private double gpa;

    public Student()
    {

    }

  
    public Student(String fName, String lName, String maj, double gpa)
    {
	firstName = fName;
	lastName = lName;
	major = maj;
	this.gpa = gpa;
	sNumber = sNumber();
    }

   
    public String getFirstName()
	{
	    return firstName;
	}

    public void setFirstName(String firstName)
	{
	    this.firstName = firstName;
	}

    public String getLastName()
	{
	    return lastName;
	}

    
    public void setLastName(String lastName)
	{
	    this.lastName = lastName;
	}

    public String getMajor()
	{
	    return major;
	}

    public void setMajor(String major)
	{
	    this.major = major;
	}

    public double getGpa()
	{
	    return gpa;
	}

  
    public void setGpa(double gpa)
	{
	    this.gpa = gpa;
	}

  
    public int getsNumber()
	{
	    return sNumber;
	}

 

    public int sNumber()
	{
	    return 1234567 + getCount();

	}

    public static int getCount()
	{
	    return count++;
	}
    

    @Override
    public String toString()
	{
	    return ("\n" + "\nS" + sNumber + "   " + firstName + " " + lastName + "  " + major + "  " + gpa + " ");

	}
}
