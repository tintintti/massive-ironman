package vahtirobo;


import vahtirobo.ui.UI;
import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * Starts AbortMission to make sure the robot stops at any time if enter is pressed.
 * Starts the UI to set values to the Guardian.
 * Starts the Guardian.
 */

public class VahtiRobo {

	public static void main(String[] args) { 
		
		new AbortMission().start();

		Guardian paras = setUpGuardian();
		
		paras.start();
		
	}

	private static Guardian setUpGuardian() {
		
		DifferentialPilot pilot = new DifferentialPilot(5.6, 16, Motor.A, Motor.B);
		LightSensor light = new LightSensor(SensorPort.S1);
		SoundSensor sound = new SoundSensor(SensorPort.S2);
		TouchSensor touch = new TouchSensor(SensorPort.S3);
		UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S4);
		
		Guardian paras = new Guardian(pilot, light, sound, touch, sonic);
		
		UI ui = new UI(light, paras);
		ui.askValues();
		
		return paras;
	}
}
