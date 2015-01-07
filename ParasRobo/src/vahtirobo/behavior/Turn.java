package vahtirobo.behavior;

import lejos.nxt.LightSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class Turn implements Behavior {
	
	private boolean suppressed;
	private DifferentialPilot pilot;
	private LightSensor light;
	private int border;
	
	public Turn(DifferentialPilot pilot, LightSensor light, int border) {
		this.pilot = pilot;
		this.light = light;
		this.border = border;
	}

	@Override
	public void action() {
		this.suppressed = false;
		pilot.travel(-10);
		if (suppressed) {
			return;
		}
		pilot.rotate(120);
		
	}

	@Override
	public void suppress() {
		this.suppressed = true;
		
	}

	@Override
	public boolean takeControl() {
		return light.getLightValue() < border;
	}

}
