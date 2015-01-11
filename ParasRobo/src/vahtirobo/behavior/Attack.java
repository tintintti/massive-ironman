package vahtirobo.behavior;

import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.*;

/**
 * If the touch sensor is pressed, rotates the motor that controls the robot's claws so that
 * the robot claws whatever hit the touch sensor.
 */

public class Attack implements Behavior {
	
	private DifferentialPilot pilot;
	private TouchSensor touch;
	
	public Attack(DifferentialPilot pilot, TouchSensor touch) {
		this.pilot = pilot;
		this.touch = touch;
	}

	@Override
	public void action() {
		
		pilot.stop();
		
		Motor.C.rotate(45);
		Motor.C.rotate(-45);
		
		pilot.travel(-5);
		
	}

	@Override
	public void suppress() {
	}

	@Override
	public boolean takeControl() {
		return touch.isPressed();
	}

}
