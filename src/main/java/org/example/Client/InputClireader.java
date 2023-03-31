package org.example.Client;

import org.example.Server.Commands.ExitCommand;
import org.example.Server.Invoker;
import org.example.exceptions.FileLoadingException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputClireader {
    /* вызываем входящий поток */
    private static Scanner inputReader = new Scanner(System.in);

    public static Scanner getInputReader() {
        return inputReader;
    }

    public static DataInOutStatus openStream() {
        try {
            OutStream.outputIntoCLI("Type commands");
            String inputData = inputReader.nextLine();
            while (inputData != null) {
                inputData = inputData.trim();
                DataInOutStatus checkedCommand = new CommandValidator().validate(inputData);
                if (checkedCommand != DataInOutStatus.SUCCESSFULLY) {
                    OutStream.outputIntoCLI(checkedCommand.getName());
                }
                if (inputData.equals("exit")) {
                    break;
                }
                inputData = inputReader.nextLine();
            }
            return DataInOutStatus.SUCCESSFULLY;
        } catch (NullPointerException |
                 NoSuchElementException e) {
            return DataInOutStatus.FAILED;
        }
    }
}
