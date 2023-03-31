package org.example.Server.Commands;

import org.example.Server.Receiver;
import org.example.Server.Interfaces.Execute;

import java.util.ArrayList;

public class SaveCommand extends AbstractCommand implements Execute {
    public SaveCommand() {
        super("save", "save collection to file", 0 , "" , false);
    }
    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        return worker.saveCollection();
    }
}
