package edu.em.project.logic;

import edu.em.project.logic.impl.BikeLogicImpl;

public final class BikeLogicProvider {
	
	private static final BikeLogicProvider instance = new BikeLogicProvider();

	private BikeLogicProvider() {}

	private BikeLogic logic = new BikeLogicImpl();

	public BikeLogic getBikeLogic() {
		return logic;
	}

	public static BikeLogicProvider getInstance() {
		return instance;
	}

}
