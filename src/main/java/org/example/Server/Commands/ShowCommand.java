package org.example.Server.Commands;

import org.example.Server.Receiver;
import org.example.Server.Interfaces.Execute;

import java.util.ArrayList;

public class ShowCommand extends AbstractCommand implements Execute {
    public ShowCommand() {
        super("show", "print to standard output all elements of the collection in string representation", 0 , "" , false);
    }

    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        StringBuilder stringBuilder = new StringBuilder();
        if (worker.getMainCollection().size() == 0) {
            return "There is no elements in main collection.";
        }
        stringBuilder.append(worker.show());
        return stringBuilder.delete(stringBuilder.toString().length() - 1, stringBuilder.toString().length()).toString();
    }
}
