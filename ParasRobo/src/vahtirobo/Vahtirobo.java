package vahtirobo;


import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;


public class Vahtirobo {

	public static void main(String[] args) { 

		Guardian paras = new Guardian(45);
		
		paras.start();

		
		while (true) {
			
			if (Button.ENTER.isPressed()) {
				System.exit(0);
			}
		}
		
	}
}
