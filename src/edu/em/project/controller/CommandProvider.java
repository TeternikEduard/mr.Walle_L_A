package edu.em.project.controller;

import java.util.HashMap;
import java.util.Map;

import edu.em.project.controller.impl.AddBikeCommand;
import edu.em.project.controller.impl.DeleteBikeByModelCommand;
import edu.em.project.controller.impl.FindBikeByColorCommand;
import edu.em.project.controller.impl.FindBikeByModelCommand;
import edu.em.project.controller.impl.FindBikeByPriceCommand;
import edu.em.project.controller.impl.FindBikeBySizeCommand;
import edu.em.project.controller.impl.NoSuchCommand;

public class CommandProvider {
    
	private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.ADD, new AddBikeCommand());
        repository.put(CommandName.FIND_MODEL, new FindBikeByModelCommand());
        repository.put(CommandName.FIND_COLOR, new FindBikeByColorCommand());
        repository.put(CommandName.FIND_SIZE, new FindBikeBySizeCommand());
        repository.put(CommandName.FIND_PRICE, new FindBikeByPriceCommand());
        repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand()); 
        repository.put(CommandName.DELETE_MODEL, new DeleteBikeByModelCommand());
    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}