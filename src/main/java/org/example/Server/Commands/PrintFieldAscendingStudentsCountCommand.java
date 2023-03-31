package org.example.Server.Commands;

import org.example.Server.Receiver;
import org.example.Server.Interfaces.Execute;
import org.example.Server.Models.StudyGroup;

import java.util.*;

public class PrintFieldAscendingStudentsCountCommand extends AbstractCommand implements Execute {

    public PrintFieldAscendingStudentsCountCommand() {
        super("print_field_ascending_students_count", "display the values of the students count" +
                " field of all elements in ascending order", 0 , "" , false);
    }

    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
            StringBuilder execution = new StringBuilder();
            Comparator<StudyGroup> field = Comparator.comparingInt(StudyGroup::getStudentsCount).reversed();
            Stack<StudyGroup> mainCollection = worker.getMainCollection();
            StudyGroup[] arrayGroups = new StudyGroup[mainCollection.size()];
            int iter = 0;
            for (StudyGroup studyGroup1 : mainCollection) {
                arrayGroups[iter] = studyGroup1;
                iter++;
            }
            Arrays.sort(arrayGroups, field);
            for (StudyGroup group : arrayGroups) {
                execution.append(group.getStudentsCount() + " ");
            }
            return execution.toString();
        }
    }
