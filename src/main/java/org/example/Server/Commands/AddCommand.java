package org.example.Server.Commands;

import org.example.Server.Receiver;
import org.example.Server.Interfaces.Execute;

import java.util.ArrayList;

public class AddCommand extends AbstractCommand implements Execute {

    public AddCommand() {
        super("add", "add a new element to the collection" , 0 , "{element}" , true);
    }

    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        String id = arguments.remove(0);
        return worker.addNew(arguments, Integer.parseInt(id));
    }
}
