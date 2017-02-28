package com.weather.api.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.weather.api.entity.Weather;
import com.weather.api.repository.WeatherRepository;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Weather> findAll() {
		List<Weather> weatherList = mongoTemplate.findAll(Weather.class);
		return weatherList;
	}

	@Override
	public Weather findOne(String id) {
		Query searchQuery = new Query(Criteria.where("id").is(id));
		Weather wthr = mongoTemplate.findOne(searchQuery, Weather.class);
		return wthr;
	}

	@Override
	public Weather create(Weather weather) {
		mongoTemplate.save(weather);
		return weather;
	}

	@Override
	public Weather update(String id, Weather weather) {
		Weather wthr = findOne(id);
		if (wthr != null)
			create(weather);
		wthr = findOne(id);
		return wthr;
	}

	@Override
	public void delete(String id) {
		Query searchQuery = new Query(Criteria.where("Id").is(id));
		mongoTemplate.remove(searchQuery, Weather.class);
	}

	@Override
	public List<String> findAllCities() {
		List<String> cityList = new ArrayList<String>();
		Query query = new Query();
		for (Weather wthr : mongoTemplate.find(query, Weather.class)) {
			cityList.add(wthr.getCity());
		}
		return cityList;
	}

	@Override
	public Weather findByCity(String city) {
		Query searchQuery = new Query(Criteria.where("city").is(city));
		Weather wthr = mongoTemplate.findOne(searchQuery, Weather.class);
		return wthr;
	}

	@Override
	public String findLatestPropertyByCity(String city, String prop) {
		String value = null;
		BasicDBObject query = new BasicDBObject();
		query.put("city", city);
		BasicDBObject fields = new BasicDBObject(prop, 1);
		DBCollection coll = mongoTemplate.getCollection("weather");
		DBCursor cursor = coll.find(query, fields);
		cursor.sort(new BasicDBObject("timestamp", -1));
		while (cursor.hasNext()) {
			BasicDBObject obj = (BasicDBObject) cursor.next();
			value = obj.getString(prop);
			break;
		}
		return value;
	}

	@Override
	public Weather findHourlyAverageWeatherByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Weather findDailyAverageWeatherByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

}
