package vahtirobo.behavior;

import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.*;

public class Drive implements Behavior{
	
	private DifferentialPilot pilot;
	private boolean suppressed;
	
	public Drive(DifferentialPilot pilot) {
		this.pilot = pilot;
	}

	@Override
	public void action() {
		this.suppressed = false;

		pilot.setTravelSpeed(10);
		pilot.forward();
		
// liikkuu eteenpäin niin kauan kunnes joku toinen behavior ottaa hallinnan
		while (!suppressed) {
			Thread.yield();
		}
	}

	@Override
	public void suppress() {
		this.suppressed = true;
	}

	@Override
	public boolean takeControl() {
		return true;
	}

}
