package edu.em.project.controller.impl;

import java.util.List;

import edu.em.project.controller.Command;
import edu.em.project.entity.Bike;
import edu.em.project.logic.BikeLogic;
import edu.em.project.logic.BikeLogicProvider;
import edu.em.project.logic.LogicException;

public class FindBikeBySizeCommand implements Command {
	
	private final BikeLogic logic = BikeLogicProvider.getInstance().getBikeLogic();

	@Override
	public String execute(String request) {
		
		String response;
		String[] params = request.split("\n");

		try {
			int size = Integer.parseInt(params[1].split("=")[1]);
			List<Bike> bike = logic.findBikeBySize(size);
			response = bike.toString();
		} catch (LogicException e) {
			response = "Ошибка поиска!";
		}

		return response;
	}
	
}
