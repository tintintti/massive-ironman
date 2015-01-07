package vahtirobo.behavior;


import java.io.File;

import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.*;


public class Charge implements Behavior {
	
	private DifferentialPilot pilot;
	private UltrasonicSensor sonic;
	private boolean suppressed;
	private File cry;
	
	public Charge(DifferentialPilot pilot, UltrasonicSensor sonic) {
		this.pilot = pilot;
		this.sonic = sonic;
		this.cry = new File("paras2.wav");
	}

	@Override
	public void action() {
		this.suppressed = false;
		

		pilot.setTravelSpeed(20);
		Sound.playSample(this.cry);
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
		return sonic.getDistance() < 60;
	}

}
