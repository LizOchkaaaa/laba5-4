package org.example.Client;

import java.util.ArrayList;

/**Class to separate name and arguments for a command*/
public class CommandValidator {
    private String commandName;
    private ArrayList<String> commandArguments = new ArrayList<>();

    public DataInOutStatus validate(String inputData) {
        String[] splitedInputData = inputData.split(" ");
        commandName = splitedInputData[0];
        for (int i = 1; i < splitedInputData.length; i++) {
            commandArguments.add(splitedInputData[i]);
        }
        return new CommandChecker().checkCorrectnessOfCommand(commandName , commandArguments);
    }
}
