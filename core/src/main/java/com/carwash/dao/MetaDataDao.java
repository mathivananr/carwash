package com.carwash.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.carwash.model.CityArea;
import com.carwash.model.City;

/**
 * Meta Data Access Object (GenericDao) interface.
 * 
 * @author mathi
 */

public interface MetaDataDao extends GenericDao<CityArea, String> {

	/**
	 * auto complete area Suggestions
	 * 
	 * @param query
	 * @return
	 */
	@Transactional
	List<City> citySuggestions(String query);

	/**
	 * get area by id
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	CityArea getArea(String id);

	/**
	 * get area by name
	 * 
	 * @param areaName
	 * @return
	 */
	@Transactional
	CityArea getAreaByName(String areaName);

	/**
	 * auto complete city Suggestions
	 * 
	 * @param query
	 * @return
	 */
	@Transactional
	List<CityArea> areaSuggestions(String query, String cityId);

	/**
	 * get city by id
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	City getCity(String id);

	/**
	 * get city by name
	 * 
	 * @param cityName
	 * @return
	 */
	@Transactional
	City getCityByName(String cityName);

}
