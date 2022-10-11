package no.hvl.dat100ptc.oppgave1;

import no.hvl.dat100ptc.TODO;

public class GPSPoint {

	private int time;
	private double latitude;
	private double longitude;
	private double elevation;
	
		
	public GPSPoint(int time, double latitude, double longitude, double elevation) {

		this.time=time;
		this.latitude=latitude;
		this.longitude=longitude;
		this.elevation=elevation;

		// Fjern linjene med throw new etterhvert som metodene implementeres
		//throw new UnsupportedOperationException(TODO.construtor("GPSPoint"));

	}

	// TODO - get/set metoder
	public int getTime() {
		
		return this.time;
		
	}

	public void setTime(int time) {
				
		this.time=time;
		//throw new UnsupportedOperationException(TODO.method());

	}

	public double getLatitude() {
		
		return this.latitude;
		//throw new UnsupportedOperationException(TODO.method());
		
	}

	public void setLatitude(double latitude) {
		
		this.latitude=latitude;
		//throw new UnsupportedOperationException(TODO.method());
		
	}

	public double getLongitude() {
		
		return this.longitude;
		//new UnsupportedOperationException(TODO.method());
		
	}

	public void setLongitude(double longitude) {
		
		this.longitude=longitude;
		//throw new UnsupportedOperationException(TODO.method());
		
	}

	public double getElevation() {
		
		return this.elevation;
		//throw new UnsupportedOperationException(TODO.method());
		
	}

	public void setElevation(double elevation) {
		
		this.elevation=elevation;
		//throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public String toString() {
		
		String str = ""+this.time+" ("+this.latitude+","+this.longitude+") "+this.elevation+"\n"; //" "+"(2.0,3.0) 5.0\n";
		
		return str;
		// TODO - start

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - slutt
		
	}
}
