package com.carwash.service;

import java.util.List;

import com.carwash.model.CityArea;
import com.carwash.model.City;
import com.carwash.model.LabelValue;

/**
 * MetaDataManager Service Interface to handle communication between web and
 * persistence layer.
 * 
 * @author mathi
 */
public interface MetaDataManager extends GenericManager<CityArea, String> {

	/**
	 * auto complete area suggestion
	 * 
	 * @param query
	 * @return
	 */
	List<City> citySuggestions(String query);

	/**
	 * get area by id
	 * 
	 * @param id
	 * @return
	 */
	CityArea getArea(String id);

	/**
	 * get area by name
	 * 
	 * @param areaName
	 * @return
	 */
	CityArea getAreaByName(String areaName);

	List<LabelValue> getCitySuggestions(String query);

	List<LabelValue> getAreaSuggestions(String query, String cityId);

	/**
	 * auto complete city suggestion
	 * 
	 * @param query
	 * @return
	 */
	List<CityArea> areaSuggestions(String query, String cityId);

	/**
	 * get city by id
	 * 
	 * @param id
	 * @return
	 */
	City getCity(String id);

	/**
	 * get city by name
	 * 
	 * @param cityName
	 * @return
	 */
	City getCityByName(String cityName);

}
