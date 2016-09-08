package org.dragon.slaughter.main;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.dragon.slaughter.constants.Constants;
import org.dragon.slaughter.constants.WeatherConditions;
import org.dragon.slaughter.model.BattleRecord;
import org.dragon.slaughter.model.BattleConditions;
import org.dragon.slaughter.model.Weather;

/**
 * Client-Server communication via Jersey
 * 
 * @author romankh
 *
 */
public class RestClient {

	private Client client;

	public RestClient() {
		client = ClientBuilder.newClient();
	}

	/**
	 * Returns battle initial conditions
	 * 
	 * @return
	 */
	public BattleConditions getBattleConditions() {

		WebTarget targetBattleStart = client.target(Constants.GAME_START_URI);
		return targetBattleStart.request(MediaType.APPLICATION_JSON).get(BattleConditions.class);
	}

	/**
	 * Returns weather conditions during battle
	 * 
	 * @return
	 */
	public WeatherConditions getWeather(long gameId) {

		String weatherUri = String.format(Constants.GAME_WEATHER_URI_TEMPLATE, gameId);
		WebTarget targetWeather = client.target(weatherUri);

		Weather weatherReport = targetWeather.request(MediaType.APPLICATION_XML).get(Weather.class);
		
		// uncomment for detailed weather information
		//System.out.println("Weather details: " + weatherReport);
		
		return WeatherConditions.convertFromString(weatherReport.getCode());
	}

	/**
	 * Returns battle result of knight versus dragon
	 * 
	 * @return
	 */
	public BattleRecord startBattle(Entity<Object> dragonEntity, long gameId) {

		String battleUri = String.format(Constants.GAME_BATTLE_URI_TEMPLATE, gameId);
		WebTarget targetBattle = client.target(battleUri);

		return targetBattle.request(MediaType.APPLICATION_JSON).put(dragonEntity, BattleRecord.class);
	}
}
