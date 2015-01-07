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
	private int border;
	
	public Guardian(DifferentialPilot pilot, UltrasonicSensor sonic, TouchSensor touch, LightSensor light, int border) {
		this.pilot = pilot;
		this.sonic = sonic;
		this.touch = touch;
		this.light = light;
		this.border = border;
	}
	
	public void run() {
		Behavior drive = new Drive(pilot);
		Behavior charge = new Charge(pilot, sonic);
		Behavior attack = new Attack(pilot, touch);
		Behavior turn = new Turn(pilot, light, border);
//		AbortMission abort = new AbortMission();
		
		Behavior[] behaviorList = {drive, charge, turn, attack};
		
		Arbitrator arbitrator = new Arbitrator(behaviorList);
		
		arbitrator.start();
		
	}

}
