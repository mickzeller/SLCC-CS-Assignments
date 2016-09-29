/********************************************************
 *  Project :  GPS
 *  Name    :  Mick Zeller
 *  Date    :  Feb 2, 2015
 ********************************************************/
package main;


public class GpsCoordients {
	
	private double latitude;
	private double longitude;

	public GpsCoordients(double lat, double lon) 
	{
		latitude = lat;
		longitude = lon;
	}


	public double getLatitude() 
	{
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() 
	{
		return " " + latitude + " " + longitude;
	}

}
