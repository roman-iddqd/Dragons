package org.dragon.slaughter.model;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Brave knight
 * 
 * @author romankh
 *
 */
@XmlRootElement
public class Knight {

	private String name;
	private int attack;
	private int armor;
	private int agility;
	private int endurance;
	
	public Knight() {}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public List<Integer> getBattleStats() {
		return Arrays.asList(attack, armor, agility, endurance);
	}
	
	@Override
	public String toString() {
		return "Knight [name=" + name + ", attack=" + attack + ", armor=" + armor + ", agility=" + agility + ", endurance=" + endurance + "]";
	}
}
