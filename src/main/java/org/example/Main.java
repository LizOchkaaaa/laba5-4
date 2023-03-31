package org.example;

import org.example.Client.FileNameListener;
import org.example.Client.InputClireader;
import org.example.Server.Invoker;
import org.example.Server.LocalDateBase;
import org.example.Server.Models.StudyGroup;
import org.example.Server.Receiver;
import org.example.Server.UniqueId;

import java.time.DateTimeException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) throws Exception {
//        var studyGroupsStack = new Stack<StudyGroup>();
//        var person = new Person("Liza", ZonedDateTime.now(), 34, "passport", Color.RED);
//        var coor = new Coordinates(34, 3434);
//        var studyGroupObj = new StudyGroup(1, "123", person, Semester.FIRST, FormOfEducation.DISTANCE_EDUCATION, coor, 34);
//        studyGroupsStack.push(studyGroupObj);
//        System.out.println(studyGroupsStack.contains(studyGroupObj));
//        var xmlFieHandler = new xmlFileHandler();
//        xmlFieHandler.save(studyGroupsStack, new File("studyGroups.xml"));
//
//        xmlFieHandler.load(new File("studyGroups.xml"));
//        var groups = xmlFieHandler.get();
//
        FileNameListener fileNameListener = new FileNameListener();
        fileNameListener.listener();
        fileNameListener.reader();
        UniqueId id = new UniqueId();
        if (fileNameListener.getGroups() != null) {
            for (StudyGroup group : fileNameListener.getGroups()) {
                if (UniqueId.getCurrentID() < group.getId()) {
                    id.setId(group.getId());
                }
            }
            LocalDateBase localDateBase = new LocalDateBase(fileNameListener.getGroups());
            Receiver receiver = new Receiver(localDateBase);
            Invoker invoker = new Invoker(receiver);
            InputClireader.openStream();
        }
    }
}