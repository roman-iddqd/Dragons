package org.dragon.slaughter.main;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.dragon.slaughter.constants.Constants;
import org.dragon.slaughter.constants.DragonStats;
import org.dragon.slaughter.constants.WeatherConditions;
import org.dragon.slaughter.model.Dragon;
import org.dragon.slaughter.model.DragonRecord;
import org.dragon.slaughter.model.Knight;

/**
 * Dragon manager that prepares dragon for every battle based on weather and
 * enemy conditions
 * 
 * @author romankh
 *
 */
public class DragonNest {

	private Dragon dragon;

	// pre-defined hardcoded options
	final Map<DragonStats, Integer> balancedDragonStats = new HashMap<DragonStats, Integer>();
	final Map<DragonStats, Integer> rainyDragonStats = new HashMap<DragonStats, Integer>();

	public DragonNest() {
		dragon = new Dragon();

		balancedDragonStats.put(DragonStats.SCALE_THICKNESS, Constants.DZEN_DRAGON_STAT);
		balancedDragonStats.put(DragonStats.CLAW_SHARPNESS, Constants.DZEN_DRAGON_STAT);
		balancedDragonStats.put(DragonStats.WING_STRENGTH, Constants.DZEN_DRAGON_STAT);
		balancedDragonStats.put(DragonStats.FIRE_BREATH, Constants.DZEN_DRAGON_STAT);

		rainyDragonStats.put(DragonStats.SCALE_THICKNESS, Constants.DZEN_DRAGON_STAT);
		rainyDragonStats.put(DragonStats.CLAW_SHARPNESS, Constants.MAX_DRAGON_STAT);
		rainyDragonStats.put(DragonStats.WING_STRENGTH, Constants.DZEN_DRAGON_STAT);
		rainyDragonStats.put(DragonStats.FIRE_BREATH, Constants.MIN_DRAGON_STAT);
	}

	/**
	 * Returns dragon for current battle
	 * 
	 * @param weather
	 *            - current weather conditions
	 * @param knight
	 *            - current enemy skills
	 * @return
	 */
	public Entity<Object> getTrainedDragon(WeatherConditions weather, Knight knight) {
		Map<DragonStats, Integer> dragonStats = getDragonStats(weather, knight.getBattleStats());
		return getDragonEntity(dragonStats);
	}

	private Map<DragonStats, Integer> getDragonStats(WeatherConditions weather, List<Integer> knightStats) {
		switch (weather) {
		case FOG:
			return getDragonStatsInFog();
		case HEAVY_RAIN:
			return getDragonStatsInRain();
		case LONG_DRY:
			return getDragonStatsInDry();
		case NORMAL:
			return getDragonStatsInNormal(knightStats);
		default:
			// will not return any dragon stats for Storm weather
			return null;
		}
	}

	/**
	 * In for dragon won't need any specific skills, knight will be useless
	 * 
	 * @return
	 */
	private Map<DragonStats, Integer> getDragonStatsInFog() {
		return balancedDragonStats;
	}

	/**
	 * During the rain dragon will use max to the claws and min to the fire
	 * 
	 * @return
	 */
	private Map<DragonStats, Integer> getDragonStatsInRain() {
		return rainyDragonStats;
	}

	/**
	 * For dry period dragon will stay in perfect balance
	 * 
	 * @return
	 */
	private Map<DragonStats, Integer> getDragonStatsInDry() {
		return balancedDragonStats;
	}

	/**
	 * Fair battle with knight, dragon's skills will be calculated based on
	 * enemy's stats
	 * 
	 * @param knightStats
	 * @return
	 */
	private Map<DragonStats, Integer> getDragonStatsInNormal(List<Integer> knightStats) {
		Map<DragonStats, Integer> dragonStats = new HashMap<DragonStats, Integer>();

		// Indexes of most outstanding and most weak Knight's skills
		int minStatId = knightStats.indexOf(Collections.min(knightStats));
		int maxStatId = knightStats.indexOf(Collections.max(knightStats));

		for (DragonStats stat : DragonStats.values()) {
			int index = stat.ordinal();
			int value = knightStats.get(index);

			if (index == maxStatId) {
				// Dragon will exceed corresponding enemy's skill by 2 points
				dragonStats.put(stat, value + 2);
			} else if (index == minStatId) {
				// Weakest skill of dragon and knight will be even
				dragonStats.put(stat, value);
			} else {
				// Dragon will have 1 point less in average skills
				dragonStats.put(stat, value - 1);
			}
		}

		return dragonStats;
	}

	/**
	 * Returns dragon entity to be send for the battle or null if dragon won't
	 * show up because of storm
	 * 
	 * @param dragontStats
	 * @return
	 */
	private Entity<Object> getDragonEntity(Map<DragonStats, Integer> dragontStats) {
		if (dragontStats == null) {
			return Entity.text("");
		} else {
			dragon.prepareDragon(dragontStats);
			return Entity.entity(new DragonRecord(dragon), MediaType.APPLICATION_JSON);
		}
	}
}
