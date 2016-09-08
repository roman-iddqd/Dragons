package org.dragon.slaughter.model;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.dragon.slaughter.constants.DragonStats;

/**
 * Dragon himself
 * 
 * @author romankh
 *
 */
@XmlRootElement(name="dragon")
public class Dragon {

	private int scaleThickness;
	private int clawSharpness;
	private int wingStrength;
	private int fireBreath;
	
	
	public void prepareDragon(Map<DragonStats, Integer> dragontStats) {
		scaleThickness = dragontStats.get(DragonStats.SCALE_THICKNESS);
		clawSharpness = dragontStats.get(DragonStats.CLAW_SHARPNESS);
		wingStrength = dragontStats.get(DragonStats.WING_STRENGTH);
		fireBreath = dragontStats.get(DragonStats.FIRE_BREATH);
	}
	
	public int getScaleThickness() {
		return scaleThickness;
	}

	public int getClawSharpness() {
		return clawSharpness;
	}

	public int getWingStrength() {
		return wingStrength;
	}

	public int getFireBreath() {
		return fireBreath;
	}

	@Override
	public String toString() {
		return "Dragon [scaleThickness=" + scaleThickness + ", clawSharpness=" + clawSharpness + ", wingStrength=" + wingStrength + ", fireBreath="
				+ fireBreath + "]";
	}
}
