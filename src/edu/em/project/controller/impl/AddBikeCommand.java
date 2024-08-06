package edu.em.project.controller.impl;

import edu.em.project.controller.Command;
import edu.em.project.entity.Bike;
import edu.em.project.logic.BikeLogic;
import edu.em.project.logic.BikeLogicProvider;
import edu.em.project.logic.LogicException;

public class AddBikeCommand implements Command {
	private final BikeLogic logic = BikeLogicProvider.getInstance().getBikeLogic();

	@Override
	public String execute(String request) {
		
		String response;
		String[] params = request.split("\n");
		
		Bike newBike;
		newBike = new Bike();
		newBike.setModel(params[1].split("=")[1]);
		newBike.setColor(params[2].split("=")[1]);
		newBike.setPrice(Double.parseDouble(params[3].split("=")[1]));
		newBike.setSize(Integer.parseInt(params[4].split("=")[1]));

		try {

			logic.addBike(newBike);
			response = "Велосипед добавлен.";

		} catch (LogicException e) {

			response = "Не получилось добавить.";
			
		}

		return response;
	}
}