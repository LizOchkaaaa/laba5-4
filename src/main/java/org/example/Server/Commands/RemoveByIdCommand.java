package org.example.Server.Commands;

import org.example.Server.Receiver;
import org.example.Server.Interfaces.Execute;

import java.util.ArrayList;

public class RemoveByIdCommand extends AbstractCommand implements Execute {
    public RemoveByIdCommand() {
        super("remove_by_id", "remove element from collection by its id", 1 , "id", false);
    }

    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        String id = arguments.remove(0);
        return worker.removeID(id);
    }
}
