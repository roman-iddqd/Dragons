package org.dragon.slaughter.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Weather report
 * 
 * @author romankh
 *
 */
@XmlRootElement(name = "report")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

	private String code;
	private String message;
	private WeatherCoordinates coords;
	private int varXRating;

	public Weather() {}


	public String getCode() {
		return code;
	}

	@XmlElement(name = "code")
	public void setCode(String code) {
		this.code = code;
	}

	@XmlElement(name = "message")
	public void setMessage(String message) {
		this.message = message;
	}

	@XmlElement(name = "coords")
	public void setCoords(WeatherCoordinates coords) {
		this.coords = coords;
	}

	@XmlElement(name = "varX-Rating")
	public void setVarXRating(int varXRating) {
		this.varXRating = varXRating;
	}

	@Override
	public String toString() {
		return "Weather [code=" + code + ", message=" + message + ", coords=" + coords + ", varXRating=" + varXRating + "]";
	}
}
