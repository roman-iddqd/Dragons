package org.dragon.slaughter.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Possible weather states
 * 
 * @author romankh
 *
 */
public enum WeatherConditions {

	NORMAL("NMR"), 
	STORM("SRO"), 
	HEAVY_RAIN("HVA"), 
	LONG_DRY("T E"), 
	FOG("FUNDEFINEDG");

	private static class Holder {
		static Map<String, WeatherConditions> CODE_MAP = new HashMap<String, WeatherConditions>();
	}

	private final String code;

	private WeatherConditions(String code) {
		this.code = code;

		Holder.CODE_MAP.put(code, this);
	}

	public String getCode() {
		return this.code;
	}

	public static WeatherConditions convertFromString(String code) {
		return Holder.CODE_MAP.get(code);
	}
}
