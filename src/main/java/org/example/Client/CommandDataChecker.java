package org.example.Client;

import org.example.Server.Commands.AbstractCommand;

import java.util.ArrayList;

public class CommandDataChecker {
    private ArrayList<String> extraArgs = new ArrayList<>();

    public ArrayList<String> getExtraArgs() {
        return extraArgs;
    }

    public DataInOutStatus checkInputCommand(AbstractCommand command) {
        var fields = MetaInfoCommand.getFields();
        extraArgs = new ObjectReading().objread(command, fields);
        if (extraArgs.size() == 0) {
            return DataInOutStatus.FAILED;
        }
        return DataInOutStatus.SUCCESSFULLY;
    }
}
