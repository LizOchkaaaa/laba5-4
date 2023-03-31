package org.example.Server.Commands;

import org.example.Server.Receiver;
import org.example.Server.Interfaces.Execute;

import java.util.ArrayList;

public class SumOfStudentsCountCommand extends AbstractCommand implements Execute {

    public SumOfStudentsCountCommand() {
        super("sum_of_students_count", "display the sum of the values of the studentsCount" +
                " field for all elements of the collection",  0 , "" , false);
    }

    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        return worker.sumOfStudentsCount();
    }
}
