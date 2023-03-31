package org.example.Client;

import org.example.Server.Commands.AbstractCommand;
import org.example.Server.FieldFetcher;
import org.example.Server.Invoker;

import java.util.HashMap;
import java.util.LinkedHashMap;


/**A class that contains the fields of the main class and commands*/
public class MetaInfoCommand {
    private static HashMap<String, AbstractCommand> mapOfCommand;
    private  static LinkedHashMap<String, String> fields;


    /*взяли все команды из Invoker*/
    public MetaInfoCommand() {
        mapOfCommand = Invoker.getCommandsMap();
        fields = new FieldFetcher().fetchFields();
    }

    public HashMap<String, AbstractCommand> getMapOfCommand() {
        return mapOfCommand;
    }

    public static LinkedHashMap<String, String> getFields() {
        return fields;
    }
}
