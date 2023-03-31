package org.example.Server.Commands;

import org.example.Server.Receiver;
import org.example.Server.Interfaces.Execute;

import java.util.ArrayList;

public class ReorderCommand extends AbstractCommand implements Execute {
    public ReorderCommand() {
        super("reorder", "sort the collection in reverse order", 0 , "" , false);
    }
    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        return worker.reorder().toString();
    }
}
