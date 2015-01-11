package vahtirobo;

import vahtirobo.behavior.*;
import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.*;

/**
 * Creates the behaviors and starts the arbitrator.
 */

public class Guardian extends Thread {
	
	private DifferentialPilot pilot;
	private UltrasonicSensor sonic;
	private LightSensor light;
	private TouchSensor touch;
	private SoundSensor sound;
	private int borderLightValue;
	private boolean backgroundIsLight;
	
	public Guardian(DifferentialPilot p, LightSensor l, SoundSensor s, TouchSensor t, UltrasonicSensor u ) {
		this.pilot = p;
		this.light = l;
		this.sound = s;
		this.touch = t;
		this.sonic = u;
	}
	
	public void run() {
		
		Behavior drive = new Drive(pilot);
		Behavior charge = new Charge(pilot, sonic);
		Behavior attack = new Attack(pilot, touch);
		Behavior turn = new Turn(pilot, light, borderLightValue, backgroundIsLight);
		Behavior listen = new HeardSomething(sound, pilot);
		
		Behavior[] behaviorList = {drive, listen, charge, turn, attack};
		
		Arbitrator arbitrator = new Arbitrator(behaviorList);
		
		System.out.println("GET OFF MY LAWN!");
		
		arbitrator.start();
		
	}
	
	public void setBackgroundIsLight(boolean isLight) {
		this.backgroundIsLight = isLight;
	}
	
	public void setBorderLightValue(int value) {
		this.borderLightValue = value;
	}

}
