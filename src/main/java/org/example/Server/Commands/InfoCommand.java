package org.example.Server.Commands;

import org.example.Server.Receiver;
import org.example.Server.Interfaces.Execute;

import java.util.ArrayList;


public class InfoCommand extends AbstractCommand implements Execute {
    public InfoCommand() {
        super("info", "print information about the collection to the standard output stream (initialization date, number of elements, etc)" , 0 , "" , false);
    }
    @Override
    public String execute(ArrayList<String> arg , Receiver worker) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size of collection - " + worker.getMainCollection().size() + "\n");
        stringBuilder.append("Data initialization - " + worker.getDateOfInitialization() + "\n");
        stringBuilder.append("Data of last change - " + worker.getDateOfLastChange());
        return stringBuilder.toString();
    }
}
