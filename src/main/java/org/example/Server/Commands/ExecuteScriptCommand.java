package org.example.Server.Commands;

import org.example.Client.CommandValidator;
import org.example.Client.DataInOutStatus;
import org.example.Client.FileReader;
import org.example.Server.Receiver;
import org.example.Server.Interfaces.Execute;

import java.util.ArrayList;

public class ExecuteScriptCommand extends AbstractCommand implements Execute {
    private ArrayList<String> historyOfFiles = new ArrayList<>();
    private static ArrayList<String> readedCommands;
    private static Integer currentCommand;

    public ExecuteScriptCommand() {
        super("execute_script", "read and execute the script from the specified file." +
                " The script contains commands in the same form in which they are entered by the user" +
                " in interactive mode", 1 , "{file_name}" , false);
    }

    public ArrayList<String> getHistoryOfFiles() {
        return historyOfFiles;
    }

    public static Integer getCurrentCommand() {
        return currentCommand;
    }

    public static void setCurrentCommand(Integer currentCommand) {
        ExecuteScriptCommand.currentCommand = currentCommand;
    }

    public static ArrayList<String> getReadedCommands() {
        return readedCommands;
    }

    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        StringBuilder execution = new StringBuilder();
        String fileName = arguments.get(0);
        if (historyOfFiles.contains(fileName)) {
            return execution.append("You have recursion in your script. Failed.").toString();
        }

        historyOfFiles.add(fileName);
        currentCommand = 0;
        readedCommands = new FileReader().readFile(fileName);
        int iter = 0;

        if (readedCommands.size() != 0) {
            while (iter < readedCommands.size()) {
                String commandLine = readedCommands.get(iter);
                if (new CommandValidator().validate(commandLine) != DataInOutStatus.SUCCESSFULLY) {
                    return execution.append("Check correctness of commands in your script '" + fileName
                            + "'. Failed.\nSome commands can be completed.").toString();
                }
                currentCommand++;
                iter = currentCommand;
            }
            execution.append("Commands from file '" + fileName + "' successfully completed.").toString();
        } else {
            execution.append("There are some errors with file '" + fileName + "'. Try again.").toString();
        }
        return execution.toString();
    }
}
