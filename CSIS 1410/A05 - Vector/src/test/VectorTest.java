/********************************************************
 *  Name    :  Mick Zeller
 *  Date    :
 ********************************************************/
package test;
import java.util.Vector;



public class VectorTest
{

	Vector vector;
	Vector vector2;


	public VectorTest()
	{
		double[] data = { 1.0, 2.0, 3.0, 4.0 };
		double[] dataSet = { 5.0, 2.0, 4.0, 1.0 };
		vector = new Vector(data);
		vector2 = new Vector(dataSet);
	}

	@Test
	public void testComponentAt()
	{
		double expected = 3.0;
		assertEquals(expected, vector.componentAt(2),0.01);
		System.out.println(expected);
	}

	@Test
	public void testPlus()
	{
		double[] distance1 = {6.0, 4.0, 7.0, 5.0};
		Vector vectorT = new Vector(distance1);
		assertEquals(vectorT.toString(), vector.plus(vector2).toString());
		System.out.println(vectorT.toString());
	}

	@Test
	public void testMinus()
	{
		double[] distance2 = {-4.0, 0.0, -1.0, 3.0};
		Vector vectors = new Vector(distance2);
		assertEquals(vectors.toString(), vector.minus(vector2).toString());
	}


	@Test
	public void testTimes()
	{
		double[] distance = {10.0, 20.0, 30.0, 40.0};
		Vector vecto = new Vector(distance);
		assertEquals(vecto.toString(), vector.times(10.0).toString());
		System.out.println(vecto.toString());
	}


	@Test
	public void testDistanceTo()
	{
		double expected1 = 5.0990195135927845;
		assertEquals(expected1, vector.distanceTo(vector2),0.01);
		double expected2 = 5.0990195135927845;
		assertEquals(expected2, vector2.distanceTo(vector),0.01);
		System.out.println(expected1);
	}

}
