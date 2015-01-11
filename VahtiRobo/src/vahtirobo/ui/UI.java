package vahtirobo.ui;

import vahtirobo.Guardian;
import vahtirobo.setup.ValueSetter;
import lejos.nxt.*;

/**
 * Asks the user to set the values for the territory's surface's light value and the border's light value.
 */

public class UI {
	private Guardian guardian;
	private ValueSetter valueSetter;
	
	public UI(LightSensor light, Guardian guardian) {
		this.guardian = guardian;
		this.valueSetter = new ValueSetter(light);
	}
	
	public void askValues() {
		
		// Asks the user to set the territory's surface's light value and prints it.
		
		System.out.println("Press <- while the robot is inside its territory.");
		
		while (!Button.LEFT.isPressed()) {
		}
		
		int backgroundValue = valueSetter.setBackgroundLightValue();	
		System.out.println(backgroundValue);
			
		
		// Asks the user to set the border's light value and prints it.
		
		System.out.println("Press -> while the light sensor is on top of the territory border.");

		while (!Button.RIGHT.isPressed()) {
		}
		
		int borderValue = valueSetter.setBorderLightValue();
		System.out.println(borderValue);
		
		
		// Sets the values for the guardian.
		this.valueSetter.setValuesForGuardian(guardian);
		
	}
	
}
