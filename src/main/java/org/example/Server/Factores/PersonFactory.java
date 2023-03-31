package org.example.Server.Factores;

import org.example.Server.Models.Color;
import org.example.Server.Models.Person;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class PersonFactory {
    public Person createPerson(String[] args) {
        String name = args[0];
        String[] argsforTime = args[1].split("-");
        ZonedDateTime time = ZonedDateTime.of(Integer.parseInt(argsforTime[0]) , Integer.parseInt(argsforTime[1]) , Integer.parseInt(argsforTime[2])  , 0 , 0 , 0 , 0 , ZoneId.systemDefault());
        Integer weight = Integer.parseInt(args[2]);
        String passport = args[3];
        Color hair = Color.valueOf(args[4]);
        Person newPerson = new Person(name , time , weight , passport , hair);
        return newPerson;
    }
}
