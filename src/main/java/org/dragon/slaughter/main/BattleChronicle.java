package org.dragon.slaughter.main;

/**
 * Keeps track of battle records for history in console logs Makes short summary
 * of all battles
 * 
 * @author romankh
 *
 */
public class BattleChronicle {

	private int winsCount = 0;
	private int defeatCount = 0;

	public void writeBattleHistory(long battleId, String knightName, boolean isVictory) {
		if (isVictory) {
			winsCount++;
			System.out.println("Victory! At day " + battleId + " " + knightName + " wasn't good enough to conquer our kindom");
		} else {
			defeatCount++;
			System.out.println("Defeat!  At day " + battleId + " " + knightName + " kill the dragon and conquer all our bases");
		}
	}

	public void publishFinalResults() {
		int totalBattleCound = winsCount + defeatCount;
		float victoryPercentage = (float) winsCount / totalBattleCound * 100;

		System.out.println("---------------------------------------------------------");
		System.out.println("Final results are:");
		System.out.println("Assault attempts: " + totalBattleCound);
		System.out.println("Slaughtered knights: " + winsCount);
		System.out.println("Murdered dragons: " + defeatCount);
		System.out.println("Head of Dragon Resources Management efficiency: " + victoryPercentage + "%");
		System.out.println("---------------------------------------------------------");
	}
}
