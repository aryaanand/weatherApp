package com.weather.api.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Wind {
	
	private int speed;
	private int degree;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}
}
