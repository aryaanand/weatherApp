package com.weather.api.service;

import java.util.List;
import java.util.Optional;

import com.weather.api.entity.Weather;

public interface WeatherService {
	
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
