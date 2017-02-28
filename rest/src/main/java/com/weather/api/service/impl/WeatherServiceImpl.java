package com.weather.api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weather.api.entity.Weather;
import com.weather.api.repository.WeatherRepository;
import com.weather.api.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService{
	
	WeatherRepository repository;
	
	public WeatherServiceImpl(WeatherRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Weather> findAll() {
		return repository.findAll();
	}

	@Override
	public Weather findOne(String id) {
		return repository.findOne(id);
	}

	@Override
	public Weather create(Weather weather) {
		return repository.create(weather);
	}

	@Override
	public Weather update(String id, Weather weather) {
		return repository.update(id, weather);
	}

	@Override
	public void delete(String id) {
		repository.delete(id);	
	}

	@Override
	public List<String> findAllCities() {
		return repository.findAllCities();
	}

	@Override
	public Weather findByCity(String city) {
		return repository.findByCity(city);
	}

	@Override
	public String findLatestPropertyByCity(String city, String prop) {
		return repository.findLatestPropertyByCity(city, prop);
	}

	@Override
	public Weather findHourlyAverageWeatherByCity(String city) {
		return repository.findHourlyAverageWeatherByCity(city);
	}

	@Override
	public Weather findDailyAverageWeatherByCity(String city) {
		return repository.findDailyAverageWeatherByCity(city);
	}

}
