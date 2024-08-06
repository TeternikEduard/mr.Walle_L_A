package edu.em.project.logic;

import java.util.List;

import edu.em.project.entity.Bike;

public interface BikeLogic {

	public void addBike(Bike bike) throws LogicException;

	public void deleteBikeByModel(String model) throws LogicException;

	public List<Bike> findBikeByModel(String model) throws LogicException;

	public List<Bike> findBikeByColor(String color) throws LogicException;

	public List<Bike> findBikeBySize(int size) throws LogicException;

	public List<Bike> findBikeByPrice(double price) throws LogicException;

	public List<Bike> allBikes(List<Bike> bikes) throws LogicException;

}