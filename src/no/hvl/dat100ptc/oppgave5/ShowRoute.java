package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
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
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}

	public void showRouteMap(int ybase) {
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
		
		
		drawCircle(
				(int)java.lang.Math.round(MARGIN + (gpspoints[0].getLongitude() - minlon) * xstep()),
				(int)java.lang.Math.round(ybase - (gpspoints[0].getLatitude() - minlat) * ystep()),
				3
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
		// throw new UnsupportedOperationException(TODO.method());

	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		
		// TODO - START
		
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT;
	}

}
