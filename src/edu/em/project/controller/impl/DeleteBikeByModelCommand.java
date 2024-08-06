package edu.em.project.controller.impl;


import edu.em.project.controller.Command;
import edu.em.project.logic.BikeLogic;
import edu.em.project.logic.BikeLogicProvider;
import edu.em.project.logic.LogicException;

public class DeleteBikeByModelCommand implements Command {

	private final BikeLogic logic = BikeLogicProvider.getInstance().getBikeLogic();

	@Override
	public String execute(String request) {

		String response;
		String[] params = request.split("\n");

		try {
			String model = params[1].split("=")[1];
			
			logic.deleteBikeByModel(model);
			response = "Велосипед удален!";
			
		} catch (LogicException e) {
			response = "Ошибка поиска!";
		}
		return response;

	}

}
