package org.example.Server.Commands;

import org.example.Server.Receiver;
import org.example.Server.Interfaces.Execute;

import java.util.ArrayList;

public class PrintUniqueFormOfEducationCommand extends AbstractCommand implements Execute {
    public PrintUniqueFormOfEducationCommand() {
        super("print_unique_form_of_education", "print the unique values of the" +
                "formOfEducation field of all elements in the collection", 1 , "" , false);
    }

    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        return worker.printEnum(arguments);
    }
}
