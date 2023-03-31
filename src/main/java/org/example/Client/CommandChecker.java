package org.example.Client;

import org.example.Server.Commands.AbstractCommand;
import org.example.Server.Commands.UpdateIdCommand;
import org.example.Server.Invoker;
import org.example.Server.Receiver;
import org.example.Server.UniqueId;
import java.util.*;

public class CommandChecker {
    public DataInOutStatus checkCorrectnessOfCommand(String commandName , ArrayList<String> argumentsToCommand) {
        DataInOutStatus correctnessStatus = DataInOutStatus.SUCCESSFULLY;
        MetaInfoCommand metaInfoCommand = new MetaInfoCommand();
        /*обращаемся ко всем коммандам и смотрим есть ли такая команда вообще */
        Map<String, AbstractCommand> mapCommand = metaInfoCommand.getMapOfCommand();
        /*ищем по имени */
        if (mapCommand.containsKey(commandName)) {
            /* создаем объект команды */
            AbstractCommand command = mapCommand.get(commandName);
            if (command.getCountOfInlineExtraArgs() == 0 && argumentsToCommand.size() != 0) {
                return DataInOutStatus.WRONGARGS;
            }
            if (command.getCountOfInlineExtraArgs() == 1 || command.isNeededElementFields()) {
                if (command.getName().equals("update")) {
                    if (argumentsToCommand.size() == 0 || argumentsToCommand.size() !=1 || Invoker.execute(command , argumentsToCommand).equals("FAILED")) {
                        OutStream.outputIntoCLI("You have wrong id");
                        return DataInOutStatus.FAILED;
                    } else {
                        correctnessStatus = checkCorrectnessOfComplicatedCommand(command, argumentsToCommand);
                    }
                } else {
                    argumentsToCommand.add(String.valueOf(UniqueId.getNewId()));
                    correctnessStatus = checkCorrectnessOfComplicatedCommand(command, argumentsToCommand);
                }
            }
            if (correctnessStatus == DataInOutStatus.SUCCESSFULLY) {
                OutStream.outputIntoCLI(Invoker.execute(command, argumentsToCommand));
            }
        } else {
            return DataInOutStatus.NOCOMMAND;
        }
        return DataInOutStatus.SUCCESSFULLY;
    }


    /*проверяем команду у которой много аргусентов на правильность введения */
    private DataInOutStatus checkCorrectnessOfComplicatedCommand(AbstractCommand command, ArrayList<String> argumentsToCommand) {
        DataInOutStatus correctnessStatus = DataInOutStatus.SUCCESSFULLY;
        if (command.isNeededElementFields()) {
            if (command.getCountOfInlineExtraArgs() == 1) {
                if (argumentsToCommand.size() != 1) {
                    return DataInOutStatus.WRONGARGS;
                }
            }
            CommandDataChecker commandChecker = new CommandDataChecker();
            correctnessStatus = commandChecker.checkInputCommand(command);
            if (correctnessStatus == DataInOutStatus.SUCCESSFULLY) {
                argumentsToCommand.addAll(commandChecker.getExtraArgs());
            }
            if (argumentsToCommand.size() == 0) {
                return DataInOutStatus.WRONGARGS;
            }
        }
        return correctnessStatus;
    }
}
