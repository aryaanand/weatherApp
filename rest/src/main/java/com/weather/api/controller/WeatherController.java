/**
 * 
 */
/**
 * @author aryaanand
 *
 */
package com.weather.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weather.api.constants.URI;
import com.weather.api.entity.Weather;
import com.weather.api.service.WeatherService;

@RestController
@RequestMapping(value = URI.WEATHER)
@Api(tags = "weather")
public class WeatherController {

	WeatherService service;

	public WeatherController(WeatherService service) {
		this.service = service;
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Create Weather data", notes = "Creates a weather data in the app with unique id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather create(@RequestBody Weather weather) {
		return service.create(weather);

	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Find All Weather data", notes = "Returns a list of weather data in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<Weather> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.ID)
	@ApiOperation(value = "Find Weather by Id", notes = "Returns a weather data by id if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather findOne(@PathVariable("id") String id) {
		return service.findOne(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = URI.ID)
	@ApiOperation(value = "Update Weather data", notes = "Updates an existing weather data")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather update(@PathVariable("id") String id,
			@RequestBody Weather weather) {
		return service.update(id, weather);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = URI.ID)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	@ApiOperation(value = "Delete Weather data", notes = "Deletes an existing weather data")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.CITY)
	@ApiOperation(value = "Find All cities whose weather is reported", notes = "Returns a list of cities in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<String> findAllCities() {
		return service.findAllCities();
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.CITY_WEATHER)
	@ApiOperation(value = "Find weather by city", notes = "Returns weather of a city in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather findByCity(@PathVariable("city") String city) {
		return service.findByCity(city);
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.CITY_PROP)
	@ApiOperation(value = "Find latest weather property by city", notes = "Returns latest weather property by city in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public String findLatestPropertyByCity(@PathVariable("city") String city,
			@PathVariable("prop") String prop) {
		return service.findLatestPropertyByCity(city, prop);
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.HOURLY_AVERAGE)
	@ApiOperation(value = "Find hourly average weather by city", notes = "Returns hourly averaged weather by city")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather findHourlyAverageWeatherByCity(
			@PathVariable("city") String city) {
		return service.findHourlyAverageWeatherByCity(city);
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.DAILY_AVERAGE)
	@ApiOperation(value = "Find daily average weather by city", notes = "Returns daily averaged weather by city")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather findDailyAverageWeatherByCity(
			@PathVariable("city") String city) {
		return service.findDailyAverageWeatherByCity(city);
	}
}