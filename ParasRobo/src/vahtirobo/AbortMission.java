package vahtirobo;

import lejos.nxt.Button;

/**
 * Exits the program if enter is pressed.
 */

public class AbortMission extends Thread {

	public void run() {
		
		while (true) {
			if (Button.ENTER.isPressed()) {
				System.exit(0);
			}
		}
	}
	
}
