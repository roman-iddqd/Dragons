package org.dragon.slaughter.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.dragon.slaughter.constants.BattleResult;

/**
 * Battle result entry
 * 
 * @author romankh
 *
 */
@XmlRootElement
public class BattleRecord {

	private String status;
	private String message;

	public BattleRecord() {}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isVictory() {
		return BattleResult.convertFromString(status) == BattleResult.VICTORY;
	}

	@Override
	public String toString() {
		return "BattleRecord [status=" + status + ", message=" + message + "]";
	}
}
