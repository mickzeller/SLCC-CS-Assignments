/********************************************************
 *  Project :  GPS
 *  Name    :  Mick Zeller
 *  Date    :  Feb 2, 2015
 ********************************************************/
package main;

public class GPSapp
{

    public static void main(String[] args)

	{
		//creation of GPSCoordinets
	    GpsCoordients thisSpot = new GpsCoordients(40.760671, -111.891122);
	    GPS spot = new GPS("SLC", thisSpot);

	    GpsCoordients garmin = spot.getPosition();
	    ;
	    System.out.printf("Gps coordinates of SLC:: %f %f %n%n", 40 + thisSpot.getLatitude(),
		    -111 + thisSpot.getLongitude());
	    System.out.printf("myGPS: Garmin: %s %n%n", garmin.toString());
	    double ghettoLat, ghettoLon;
	    for (int i = 1; i < 4; i++)
	    {
		spot.updatePosition(garmin);
		ghettoLat = garmin.getLatitude();
		ghettoLon = garmin.getLongitude();
		System.out.printf("Position update %d %.6f %.6f%n",i,ghettoLat,ghettoLon);

	    }

	}
}
