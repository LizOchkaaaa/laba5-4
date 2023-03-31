package org.example.Server.Commands;

import org.example.Server.Receiver;
import org.example.Server.Interfaces.Execute;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ExitCommand extends AbstractCommand implements Execute {
    public ExitCommand() {
        super("exit", "terminate program (without saving to file)", 0 , "" , false);
    }
    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        return "Exiting from the execution process.";
    }
}
