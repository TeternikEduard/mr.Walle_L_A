package edu.em.project.logic.impl;

import java.util.List;

import edu.em.project.dao.BikeDao;
import edu.em.project.dao.DaoException;
import edu.em.project.dao.DaoProvider;
import edu.em.project.entity.Bike;
import edu.em.project.logic.BikeLogic;
import edu.em.project.logic.LogicException;

public class BikeLogicImpl implements BikeLogic {

	private final BikeDao bikeDao = DaoProvider.getInstance().getBikeDao();

	@Override
	public void addBike(Bike bike) throws LogicException {
		try {
			bikeDao.addBike(bike);
		} catch (DaoException e) {
			throw new LogicException(e);
		}

	}

	@Override
	public void deleteBikeByModel(String model) throws LogicException {
		try {
			bikeDao.deleteBikeByModel(model);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public List<Bike> findBikeByModel(String model) throws LogicException {

		try {
			return bikeDao.findBikeByModel(model);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public List<Bike> findBikeByColor(String color) throws LogicException {

		try {
			return bikeDao.findBikeByColor(color);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public List<Bike> findBikeBySize(int size) throws LogicException {

		try {
			return bikeDao.findBikeBySize(size);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	public List<Bike> findBikeByPrice(double price) throws LogicException {

		try {
			return bikeDao.findBikeByPrice(price);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public List<Bike> allBikes(List<Bike> bikes) throws LogicException {

		try {
			return bikeDao.allBikes(bikes);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

}
