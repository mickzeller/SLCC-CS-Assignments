/********************************************************
 *  Project :  GPS
 *  Name    :  Mick Zeller
 *  Date    :  Feb 2, 2015
 ********************************************************/
package main;


public class GPS
{

    private String name;
    private GpsCoordients position;

  
    public GPS(String n, GpsCoordients pos)
    {
	n = name;
	position = new GpsCoordients(pos.getLatitude(), pos.getLongitude());

    }

    public GpsCoordients getPosition()
	{

	    return position;
	}

    public void updatePosition(GpsCoordients position)
	{

	    position.setLongitude(position.getLongitude() + Math.random()* 5.0 - 2.5);
	    position.setLatitude(position.getLatitude() + Math.random()* 5.0 - 2.5);
	}

    @Override
    public String toString()
	{
	    return String.format("GPS %s,  position %.6f%n", name, position);
	}

}
