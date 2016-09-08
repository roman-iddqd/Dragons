package org.dragon.slaughter.main;

import javax.ws.rs.client.Entity;

import org.dragon.slaughter.constants.WeatherConditions;
import org.dragon.slaughter.model.BattleRecord;
import org.dragon.slaughter.model.BattleConditions;

/**
 * Battle manager
 * 
 * @author romankh
 *
 */
public class KindomManager {

	private RestClient restClient;
	private DragonNest dragonNest;
	private BattleChronicle chronicle;
	
	public KindomManager() {
		restClient = new RestClient();
		dragonNest = new DragonNest();
		chronicle = new BattleChronicle();
	}
	
	/**
	 * Starts sequence of battles
	 * @param numberOfBattles
	 */
	public void start(int numberOfBattles) {
		// Simply repeats battles one after another
		for (int i = 0; i < numberOfBattles; i++) {
			startNewBattle();
		}
		
		chronicle.publishFinalResults();
	}

	/**
	 * 	Battle process
	 */
	private void startNewBattle() {
		
		BattleConditions battleStartRecord = restClient.getBattleConditions();
		WeatherConditions weather = restClient.getWeather(battleStartRecord.getGameId());
		Entity<Object> dragonEntity = dragonNest.getTrainedDragon(weather, battleStartRecord.getKnight());
		BattleRecord battleResult = restClient.startBattle(dragonEntity, battleStartRecord.getGameId());
		
		// To check detailed battle logs - uncomment
		//System.out.println("Attack details: " + battleStartRecord);
		//System.out.println("Weather conditions: " + weather);
		//System.out.println("Dragon stats: " + dragonEntity);
		//System.out.println("Battle results: " + battleResult);
		
		chronicle.writeBattleHistory(battleStartRecord.getGameId(), battleStartRecord.getKnight().getName(), battleResult.isVictory());
	}
}
