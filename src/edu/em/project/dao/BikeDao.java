package edu.em.project.dao;

import java.util.List;

import edu.em.project.entity.Bike;

public interface BikeDao {

	public void addBike(Bike bike) throws DaoException;

	public List<Bike> findBikeByModel(String model) throws DaoException;

	public List<Bike> findBikeByColor(String color) throws DaoException;

	public List<Bike> findBikeBySize(int size) throws DaoException;

	public List<Bike> findBikeByPrice(double price) throws DaoException;

	public List<Bike> allBikes(List<Bike> bikes) throws DaoException;
	
	public void deleteBikeByModel(String model) throws DaoException;

}
