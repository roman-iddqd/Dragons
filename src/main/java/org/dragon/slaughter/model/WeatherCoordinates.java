package org.dragon.slaughter.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Some coordinates of unknown location
 * 
 * @author romankh
 *
 */
@XmlRootElement
public class WeatherCoordinates {

	private double x;
	private double y;
	private double z;
	
	public WeatherCoordinates() {}

	@XmlElement(name = "x")
	public void setX(double x) {
		this.x = x;
	}

	@XmlElement(name = "y")
	public void setY(double y) {
		this.y = y;
	}

	@XmlElement(name = "z")
	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "WeatherCoordinates [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
}
