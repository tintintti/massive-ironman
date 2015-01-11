package vahtirobo.setup;

import vahtirobo.Guardian;
import lejos.nxt.LightSensor;

/**
 * Sets the values needed for the Guardian:
 * -light value for the border and
 * -borderIsDarkerThanTerritory so the Guardian knows whether the border is darker than the territory surface.
 */

public class ValueSetter {
	private int backgroundLightValueFromSensor;
	private int borderLightValueFromSensor;
	private int borderLightValue;
	private LightSensor light;
	private boolean borderIsDarkerThanTerritory;
	
	public ValueSetter(LightSensor light) {
		this.light = light;
	}
	
	
	public void setValuesForGuardian(Guardian g) {
		
		this.getBorderValue();
		
		g.setBackgroundIsLight(this.borderIsDarkerThanTerritory);
		g.setBorderLightValue(borderLightValue);
	}
	
	public int setBackgroundLightValue() {
		
		this.backgroundLightValueFromSensor = light.getLightValue();
		
		return this.backgroundLightValueFromSensor;
	}
	
	public int setBorderLightValue() {
	
		this.borderLightValueFromSensor = light.getLightValue();
		
		return this.borderLightValueFromSensor;
	}
	
	private void getBorderValue() {
		/* Sets the border's light value to a number between the light value of the territory's surface
		 * and the light value of the border, so the light sensor values have some room for variation.
		 * Sets the boolean borderIsDarkerThanTerritory to true if the territory's surface is lighter than
		 * the border and false otherwise. */
		
		
		if (this.backgroundLightValueFromSensor > this.borderLightValueFromSensor) {
			
			int i = this.backgroundLightValueFromSensor - this.borderLightValueFromSensor;
			this.borderLightValue = this.backgroundLightValueFromSensor - ( i / 2 );
			
			this.borderIsDarkerThanTerritory = true;
			
		} else {
			
			int i = this.borderLightValueFromSensor - this.backgroundLightValueFromSensor;
			this.borderLightValue = this.backgroundLightValueFromSensor + ( i / 2 );
			
			this.borderIsDarkerThanTerritory = false;
		}
		
	}

}
