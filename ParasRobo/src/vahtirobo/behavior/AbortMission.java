package vahtirobo.behavior;

import lejos.nxt.Button;
import lejos.robotics.subsumption.*;

public class AbortMission implements Behavior {
	

	@Override
	public void action() {
		System.exit(0);
	}

	@Override
	public void suppress() {
	}

	@Override
	public boolean takeControl() {
		return Button.ENTER.isPressed();
	}
	

}
