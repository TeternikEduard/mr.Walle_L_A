package edu.em.project.controller.impl;

import edu.em.project.controller.Command;

public class NoSuchCommand implements Command {
	
	@Override
	public String execute(String request) {
		return "Нет такой функции!";
	}
	
}
