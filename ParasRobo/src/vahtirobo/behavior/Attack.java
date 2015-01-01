package vahtirobo.behavior;

import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.*;

public class Attack implements Behavior {
	
	private DifferentialPilot pilot;
	private TouchSensor touch;
	private boolean suppressed;
	
	public Attack(DifferentialPilot pilot, TouchSensor touch) {
		this.pilot = pilot;
		this.touch = touch;
	}

	@Override
	public void action() {
		this.suppressed = false;
		
		boolean attackOver = false;
		pilot.stop();
		Motor.C.rotate(45);
		Motor.C.rotate(-45);
		pilot.travel(-5);
		attackOver = true;
		
		while (!suppressed && !attackOver) {
			Thread.yield();
		}
		
	}

	@Override
	public void suppress() {
		this.suppressed = true;
	}

	@Override
	public boolean takeControl() {
		return touch.isPressed();
	}

}
