/********************************************************
 *  Name    :  Mick Zeller
 *  Date    :  February 14, 2015
 ********************************************************/
package main;

public class InheritenceApp
{

    public static void main(String[] args)
	{
	    Rectangle myRectangle = new Rectangle(5, 4);
	    Square mySquare = new Square(4);
	    IsoscelesRightTriangle myIsoscelesRightTriangle = new IsoscelesRightTriangle(5);
	    Circle myCircle = new Circle(4);

	    rectangle(myRectangle);
	    square(mySquare);
	    rightTriangle(myIsoscelesRightTriangle);
	    circle(myCircle);
	    rectangle2(mySquare);
	    rectangleArray(myRectangle, mySquare);
	    String word = "high five!";
	    int length = word.length();
	    System.out.print(length);
	}

    private static void rectangleArray(Rectangle myRectangle, Square mySquare)
	{
	    System.out.println("Rectangle Array\n---------");

	    Rectangle[] rectangles =
	    { /* rectangle2(mySquare), */ mySquare, myRectangle };
	    for (Rectangle list : rectangles)
	    {
		System.out.println(list);
	    }
	}

    private static void rectangle2(Square mySquare)
	{
	    Rectangle rectangle = mySquare;
	    System.out.println("Rectangle2\n---------");
	    System.out.println(rectangle);
	    System.out.println("Length: " + rectangle.getLength());
	    System.out.println("Width: " + rectangle.getWidth());
	    System.out.println();
	}

    private static void rightTriangle(IsoscelesRightTriangle myIsoscelesRightTriangle)
	{
	    System.out.println(myIsoscelesRightTriangle.toString());
	    System.out.println("Leg: " + myIsoscelesRightTriangle.getLeg());
	    System.out.println("Hypotenuse " + myIsoscelesRightTriangle.hypotonus(myIsoscelesRightTriangle.getLeg()));
	}

    private static void circle(Circle myCircle)
	{
	    System.out.println(myCircle.toString());
	    System.out.println("Diameter: " + myCircle.diameter());
	    System.out.println("Circumference: " + myCircle.circumference());
	    System.out.println("Radius: " + myCircle.getRadius());
	    System.out.println();
	}

    private static void square(Square mySquare)
	{
	    System.out.println(mySquare.toString());
	    System.out.println("Side: " + mySquare.getSide());
	    System.out.println();
	}

    private static void rectangle(Rectangle myRectangle)
	{
	    System.out.println(myRectangle.toString());
	    System.out.println();
	    System.out.println("Length: " + myRectangle.getLength());
	    System.out.println("Width: " + myRectangle.getWidth());
	    System.out.println();
	}

}
