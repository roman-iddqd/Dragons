package org.dragon.slaughter.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Dragon entity
 * 
 * @author romankh
 *
 */
@XmlRootElement
public class DragonRecord {

	public Dragon dragon;

	public DragonRecord(Dragon dragon) {
		this.dragon = dragon;
	}

	@Override
	public String toString() {
		return "DragonRecord [dragon=" + dragon + "]";
	}
}
