package vahtirobo;


import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;


public class Vahtirobo {

	public static void main(String[] args) {
		
		DifferentialPilot pilot = new DifferentialPilot(5.6f, 17f, Motor.A, Motor.B);
		UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S4);
		LightSensor light = new LightSensor(SensorPort.S1);
		TouchSensor touch = new TouchSensor(SensorPort.S3); 

		Guardian paras = new Guardian(pilot, sonic, touch, light, 45);
		
		paras.run();
		
	}
}
