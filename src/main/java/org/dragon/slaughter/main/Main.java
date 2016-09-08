package org.dragon.slaughter.main;

import org.dragon.slaughter.constants.Constants;

/**
 * Entry point to the "Dragons of Mugloar"
 * 
 * @author romankh
 *
 */
public class Main {

	public static void main(String[] args) {
		new KindomManager().start(getBattleCount(args));
	}

	/**
	 * Retunrs number of battles to simulate
	 * @param args - command line args
	 * @return
	 */
	private static int getBattleCount(String[] args) {
		int numberOfBattles = Constants.DEFAULT_NUM_BATTLES;

		if (args.length > 0) {
			try {
				numberOfBattles = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.out.println("Invalid number of battles: " + e + "; we will use default count: " + numberOfBattles);
			}
		}

		return numberOfBattles;
	}
}
