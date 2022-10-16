package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 600;
	private static int MAPYSIZE = 600;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon)); 

		return xstep;
	}

	// antall y-pixels per breddegrad
	public double ystep() {
	
		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		double ystep = MAPYSIZE / (Math.abs(maxlat-minlat));
		
		return ystep;
		// TODO - SLUTT
		
	}

	public void showRouteMap(int ybase) {
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
		int stoppPunkt = gpspoints.length - 1;
		setColor(0, 0, 255);
		fillCircle(
				(int)java.lang.Math.round(MARGIN + (gpspoints[0].getLongitude() - minlon) * xstep()),
				(int)java.lang.Math.round(ybase - (gpspoints[0].getLatitude() - minlat) * ystep()),
				6
				);

		for (int i = 1; i < gpspoints.length; i++) {
			if (gpspoints[i].getElevation()>gpspoints[i-1].getElevation())
				setColor(255,0,0);
			else 
				setColor(0,255,0);
			fillCircle(
					(int)java.lang.Math.round(MARGIN + (gpspoints[i].getLongitude() - minlon) * xstep()),
					(int)java.lang.Math.round(ybase - (gpspoints[i].getLatitude() - minlat) * ystep()),
					3
					);
			drawLine(
					(int)java.lang.Math.round(MARGIN + (gpspoints[i].getLongitude() - minlon) * xstep()),
					(int)java.lang.Math.round(ybase - (gpspoints[i].getLatitude() - minlat) * ystep()),
					(int)java.lang.Math.round(MARGIN + (gpspoints[i-1].getLongitude() - minlon) * xstep()),
					(int)java.lang.Math.round(ybase - (gpspoints[i-1].getLatitude() - minlat) * ystep())
					);	
		}
		setColor(0, 0, 255);
		fillCircle(
				(int)java.lang.Math.round(MARGIN + (gpspoints[stoppPunkt].getLongitude() - minlon) * xstep()),
				(int)java.lang.Math.round(ybase - (gpspoints[stoppPunkt].getLatitude() - minlat) * ystep()),
				6
				);
	}

	private static double WEIGHT = 80.0;
	
	public void showStatistics() {

		int TEXTDISTANCE = 20;
		int STATSDIST = 150;
		int COLDIST = 131;

		setColor(0,0,0);
		setFont("Courier",12);
		
		// TODO - START
		String timestr = "Total Time";
		String distStr = "Total Distance";
		String elevStr = "Total Elevation";
		String mSpeedStr = "Max Speed";
		String aSpeedStr = "Average Speed";
		String energyStr = "Energy";

		drawString(timestr, MARGIN, TEXTDISTANCE);
		drawString(distStr, MARGIN, TEXTDISTANCE*2);
		drawString(elevStr, MARGIN, TEXTDISTANCE*3);
		drawString(mSpeedStr, MARGIN, TEXTDISTANCE*4);
		drawString(aSpeedStr, MARGIN, TEXTDISTANCE*5);
		drawString(energyStr, MARGIN, TEXTDISTANCE*6);
		
		drawString(":", COLDIST, TEXTDISTANCE);
		drawString(":", COLDIST, TEXTDISTANCE*2);
		drawString(":", COLDIST, TEXTDISTANCE*3);
		drawString(":", COLDIST, TEXTDISTANCE*4);
		drawString(":", COLDIST, TEXTDISTANCE*5);
		drawString(":", COLDIST, TEXTDISTANCE*6);

		drawString(GPSUtils.formatTime(gpscomputer.totalTime()), STATSDIST, TEXTDISTANCE);
		drawString(GPSUtils.formatDouble((gpscomputer.totalDistance() / 1000)) + " km", STATSDIST, TEXTDISTANCE*2);
		drawString(GPSUtils.formatDouble(gpscomputer.totalElevation()) + " m", STATSDIST, TEXTDISTANCE*3);
		drawString(GPSUtils.formatDouble(gpscomputer.maxSpeed()) + (" km/t"), STATSDIST, TEXTDISTANCE*4);
		drawString(GPSUtils.formatDouble(gpscomputer.averageSpeed()) + " km/t", STATSDIST, TEXTDISTANCE*5);
		drawString(GPSUtils.formatDouble(gpscomputer.totalKcal(WEIGHT)) + " kcal", STATSDIST, TEXTDISTANCE*6);
		// TODO - SLUTT;
		// Testing
	}

}
