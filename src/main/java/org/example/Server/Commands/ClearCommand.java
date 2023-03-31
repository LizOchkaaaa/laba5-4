package org.example.Server.Commands;

import org.example.Server.Receiver;
import org.example.Server.Interfaces.Execute;

import java.util.ArrayList;

public class ClearCommand extends AbstractCommand implements Execute {
    public ClearCommand() {
        super("clear", "clear the collection", 0 , "" , false);
    }
    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        return worker.clearCollection();
    }
}
