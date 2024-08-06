package edu.em.project.controller;

public class Controller {
	private final char delimiter = '\n';

	private final CommandProvider provider = new CommandProvider();

	public String doAction(String request) {
		String commandName;
		Command executionCommand;

		commandName = request.substring(0, request.indexOf(delimiter));
		executionCommand = provider.getCommand(commandName.toUpperCase());

		String response;
		response = executionCommand.execute(request);

		return response;
	}
}