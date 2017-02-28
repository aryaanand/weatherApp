package com.weather.api.repository;

import java.util.List;

import com.weather.api.entity.Weather;

public interface WeatherRepository {

	public List<Weather> findAll();

	public Weather findOne(String id);

	public Weather create(Weather weather);

	public Weather update(String id, Weather weather);

	public void delete(String id);

	public List<String> findAllCities();

	public Weather findByCity(String city);

	public String findLatestPropertyByCity(String city, String prop);

	public Weather findHourlyAverageWeatherByCity(String city);
	
	public Weather findDailyAverageWeatherByCity(String city);

}
