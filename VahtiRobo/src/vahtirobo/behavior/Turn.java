package vahtirobo.behavior;

import lejos.nxt.LightSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

/**
 * Turns the robot around about 120 degrees when the light sensor detects the border.
 */

public class Turn implements Behavior {
	
	private DifferentialPilot pilot;
	private LightSensor light;
	private int borderLightValue;
	private boolean borderIsDarkerThanTerritory;
	
	public Turn(DifferentialPilot pilot, LightSensor light, int border, boolean borderIsDarkerThanTerritory) {
		this.pilot = pilot;
		this.light = light;
		this.borderLightValue = border;
		this.borderIsDarkerThanTerritory = borderIsDarkerThanTerritory;
	}

	@Override
	public void action() {
		pilot.travel(-10);
		pilot.rotate(120);
	}

	@Override
	public void suppress() {
		
	}

	@Override
	public boolean takeControl() {
		
		if (borderIsDarkerThanTerritory) {
			return light.getLightValue() < borderLightValue;
		}
		
		return light.getLightValue() > borderLightValue;
		
	}

	
}
