package vahtirobo.behavior;


import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.*;


public class Charge implements Behavior {
	
	private DifferentialPilot pilot;
	private UltrasonicSensor sonic;
	private boolean suppressed;
	
	public Charge(DifferentialPilot pilot, UltrasonicSensor sonic) {
		this.pilot = pilot;
		this.sonic = sonic;
	}

	@Override
	public void action() {
		this.suppressed = false;
		
		pilot.setTravelSpeed(20);
		pilot.forward();
		
		while (!suppressed) {
			Thread.yield();
		}
		
		pilot.setTravelSpeed(10);
		pilot.forward();
	}

	@Override
	public void suppress() {
		this.suppressed = true;
	}

	@Override
	public boolean takeControl() {
		return sonic.getDistance() < 40;
	}

}
