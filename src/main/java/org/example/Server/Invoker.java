package org.example.Server;

import org.example.Server.Commands.*;
import org.example.Server.Interfaces.Execute;
import org.example.Server.Receiver;

import java.util.ArrayList;
import java.util.HashMap;

public class Invoker {
    private static Receiver receiver;
    private static HashMap<String, AbstractCommand> commandsMap;
    public Invoker(Receiver receiver) {
        this.receiver = receiver;
        commandsMap = new HashMap<>();
        var helpCommand = new HelpCommand(commandsMap.values());
        var infoCommand = new InfoCommand();
        var exitCommand = new ExitCommand();
        var clearCommand = new ClearCommand();
        var saveCommand = new SaveCommand();
        var showCommand = new ShowCommand();
        var addCommand = new AddCommand();
        var updateCommand = new UpdateIdCommand();
        var removeCommand = new RemoveByIdCommand();
        var executeCommand = new ExecuteScriptCommand();
        var addMaxCommand = new AddIfMaxCommand();
        var remove1Command = new RemoveGreaterCommand();
        var reorderCommand = new ReorderCommand();
        var sumOfStudentsCountCommand = new SumOfStudentsCountCommand();
        var printCommand = new PrintUniqueFormOfEducationCommand();
        var printFieldCommand = new PrintFieldAscendingStudentsCountCommand();

        commandsMap.put("help", helpCommand);
        commandsMap.put("info", infoCommand);
        commandsMap.put("exit", exitCommand);
        commandsMap.put("clear", clearCommand);
        commandsMap.put("save", saveCommand);
        commandsMap.put("show", showCommand);
        commandsMap.put("add", addCommand);
        commandsMap.put("update", updateCommand);
        commandsMap.put("remove_by_id", removeCommand);
        commandsMap.put("execute_script", executeCommand);
        commandsMap.put("add_if_max", addMaxCommand);
        commandsMap.put("remove_greater", remove1Command);
        commandsMap.put("reorder", reorderCommand);
        commandsMap.put("sum_of_students_count", sumOfStudentsCountCommand);
        commandsMap.put("print_unique_form_of_education", printCommand);
        commandsMap.put("print_field_ascending_students_count", printFieldCommand);
    }

    public static String execute(Execute command , ArrayList<String> arguments) {
        StringBuilder excution = new StringBuilder();
        excution.append(command.execute(arguments, receiver));
        return excution.toString();
    }

    public static HashMap<String, AbstractCommand> getCommandsMap(){
        return commandsMap;
    }
}
