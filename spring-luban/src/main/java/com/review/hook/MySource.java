package com.review.hook;

public class MySource {
	private Integer temperature;
	private Integer humidity;
	private Integer atmos;

	public MySource(){

	}
	public MySource(Integer temperature, Integer humidity, Integer atmos) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.atmos = atmos;
	}

	public Integer getTemperature() {
		return temperature;
	}

	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	public Integer getAtmos() {
		return atmos;
	}

	public void setAtmos(Integer atmos) {
		this.atmos = atmos;
	}
}
