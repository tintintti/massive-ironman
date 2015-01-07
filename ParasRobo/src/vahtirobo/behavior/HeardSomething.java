package vahtirobo.behavior;

import lejos.nxt.SoundSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class HeardSomething implements Behavior {
	private SoundSensor sound;
	private DifferentialPilot pilot;
	private boolean suppressed;
	
	public HeardSomething(SoundSensor s, DifferentialPilot p) {
		this.sound = s;
		this.pilot = p;
	}

	@Override
	public void action() {
		this.suppressed = false;
		
		this.turnRight();
		
		this.turnLeft();

		this.turnRight();
		
	}
	
	private void turnRight() {
		int turns = 0;
		
		while (!suppressed && turns <= 20) {
			pilot.rotate(5);
			turns++;
		}
	}
	
	private void turnLeft() {
		int turns = 0;
		
		while (!suppressed && turns <= 40) {
			pilot.rotate(-5);
			turns++;
		}
	}

	@Override
	public void suppress() {
		this.suppressed = true;
	}

	@Override
	public boolean takeControl() {
		return this.sound.readValue() > 60;
	}
	

}
