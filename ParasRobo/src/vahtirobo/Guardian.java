package vahtirobo;

import vahtirobo.behavior.*;
import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.*;

public class Guardian extends Thread {
	
	private DifferentialPilot pilot;
	private UltrasonicSensor sonic;
	private LightSensor light;
	private TouchSensor touch;
	private SoundSensor sound;
	private int border;
	
	public Guardian(int border) {
		this.pilot = new DifferentialPilot(5.6f, 17f, Motor.A, Motor.B);
		this.light = new LightSensor(SensorPort.S1);
		this.sound = new SoundSensor(SensorPort.S2);
		this.touch = new TouchSensor(SensorPort.S3);
		this.sonic = new UltrasonicSensor(SensorPort.S4);
		this.border = border;
	}
	
	public void run() {
		Behavior drive = new Drive(pilot);
		Behavior charge = new Charge(pilot, sonic);
		Behavior attack = new Attack(pilot, touch);
		Behavior turn = new Turn(pilot, light, border);
		Behavior listen = new HeardSomething(sound, pilot);
		
		Behavior[] behaviorList = {drive, listen, charge, turn, attack};
		
		Arbitrator arbitrator = new Arbitrator(behaviorList);
		
		arbitrator.start();
		
	}

}
