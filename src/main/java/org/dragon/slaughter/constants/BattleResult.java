package org.dragon.slaughter.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * All possible battle results
 * 
 * @author romankh
 *
 */
public enum BattleResult {
	VICTORY("Victory"), 
	DEFEAT("Defeat");

	private static class Holder {
		static Map<String, BattleResult> CODE_MAP = new HashMap<String, BattleResult>();
	}

	private BattleResult(String code) {
		Holder.CODE_MAP.put(code, this);
	}

	public static BattleResult convertFromString(String code) {
		return Holder.CODE_MAP.get(code);
	}
}
