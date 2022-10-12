package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max;

		max = da[0];

		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}

		return max;
	}

	public static double findMin(double[] da) {

		double min;
		min = da[0];

		for (double e : da) {
			if (e < min) {
				min = e;
			}
		}
		return min;

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] latitudeTab = new double[gpspoints.length];

		for (int i = 0; i < gpspoints.length; i++) {

			latitudeTab[i] = gpspoints[i].getLatitude();
		}

		return latitudeTab;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] longitudeTab = new double[gpspoints.length];

		for (int i = 0; i < gpspoints.length; i++) {

			longitudeTab[i] = gpspoints[i].getLongitude();
		}

		return longitudeTab;
	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;
		
		latitude1= Math.toRadians(gpspoint1.getLatitude());
		latitude2= Math.toRadians(gpspoint2.getLatitude());
		longitude1= Math.toRadians(gpspoint1.getLongitude());
		longitude2= Math.toRadians(gpspoint2.getLongitude());
		double dLat = latitude2 - latitude1;
		double dLong = longitude2 - longitude1;
		double avstand = Math.pow((sin(dLat / 2)), 2) + cos(latitude1) * cos(latitude2) * Math.pow(sin(dLong / 2),2);
		double c =2 *atan2(sqrt(avstand),sqrt(1-avstand));
		d = R *c;
		// TODO - SLUTT
return d;
	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		double tid1 =gpspoint1.getTime();
		double tid2 =gpspoint2.getTime();
		
		double secs = tid2-tid1;
		double speed;

		 double distanse =distance(gpspoint1, gpspoint2);
		 speed = distanse/secs;
		 speed = speed *3.6; // konverterer fra m/s til km/h

		return speed;
	}

	public static String formatTime(int secs) {
//
//		String timestr;
//		String TIMESEP = ":";
//
//		double minutter = secs/60;
//		double timer = minutter/60;
//		
//		double klokke = timer%


				String TIMESEP = ":";
        int timer = secs/(60*60);
        secs = (secs - timer*60*60);
        int minu = secs/60;
        secs = secs-minu*60;
        

        String timestr = timer+TIMESEP+minu+TIMESEP+secs;
        return timestr;

	}

	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {
	
		
double avrundet = Math.round(d*100)/100.0;

//String str ="      "+ String.format("%.3g%n", avrundet);,
 String str ="      "+ Double.toString(avrundet);
return str;

		

	}
}
