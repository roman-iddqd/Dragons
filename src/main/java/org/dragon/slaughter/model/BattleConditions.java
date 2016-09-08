package org.dragon.slaughter.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Battle initial conditions
 * 
 * @author romankh
 *
 */
@XmlRootElement
public class BattleConditions {

	private long gameId;
	private Knight knight;
	
	public BattleConditions() {}
	
	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public Knight getKnight() {
		return knight;
	}

	public void setKnight(Knight knight) {
		this.knight = knight;
	}
	
	@Override
	public String toString() {
		return "KnightRecord [gameId=" + gameId + ", knight=" + knight + "]";
	}
}
