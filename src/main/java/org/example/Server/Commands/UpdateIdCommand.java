package org.example.Server.Commands;

import org.example.Client.DataInOutStatus;
import org.example.Server.Receiver;
import org.example.Server.Interfaces.Execute;

import java.util.ArrayList;

public class UpdateIdCommand extends AbstractCommand implements Execute {
    public UpdateIdCommand() {
        super("update", "update the value of the collection element whose" +
                " id is equal to the given one", 1 , "id {element}" , true);
    }

    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        if(arguments.size()==1) {
            if (!worker.check(arguments)) {
                return "FAILED";
            }
            return "TRUE";
        }
        String id = arguments.remove(0);
        try {
            return worker.update(arguments, Integer.parseInt(id));
        } catch (NumberFormatException e) {
            return "Failed. Wrong Id.";
        }

    }




    public boolean checkElement(ArrayList<String> arguments , Receiver worker) {
        return worker.check(arguments);
    }

}

