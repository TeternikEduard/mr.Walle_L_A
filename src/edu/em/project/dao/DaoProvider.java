package edu.em.project.dao;

import edu.em.project.dao.impl.FileBikeDao;

public final class DaoProvider {

	private static final DaoProvider INSTANCE = new DaoProvider();

	private DaoProvider() {
	}

	private BikeDao bikeDao = new FileBikeDao();

	public BikeDao getBikeDao() {
		return bikeDao;
	}

	public static DaoProvider getInstance() {
		return INSTANCE;
	}

}
