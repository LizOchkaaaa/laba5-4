package org.example.Client;

import org.example.exceptions.FileLoadingException;
import org.example.exceptions.NoAccessToFileException;
import org.example.Server.Models.StudyGroup;
import org.example.Server.XmlUtils.xmlFileHandler;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Stack;


public class FileNameListener {
    private String fileName;
    private Stack<StudyGroup> groups;

    public String getFileName(){
        return fileName;
    }

    public DataInOutStatus listener(){
        OutStream.outputIntoCLI("Type name of file.");
        try {
            this.fileName = InputClireader.getInputReader().nextLine();
        }catch (NoSuchElementException e) {
            return DataInOutStatus.FAILED;
        }
        return DataInOutStatus.SUCCESSFULLY;
    }

    public DataInOutStatus reader(){
        try {
            File file1 = new File(fileName);
            xmlFileHandler read  = new xmlFileHandler();
            read.load(file1);
            groups = read.get();
        }catch (NoAccessToFileException | FileLoadingException | NullPointerException e) {
            return DataInOutStatus.FAILED;
        }
        return DataInOutStatus.SUCCESSFULLY;
    }

    public Stack<StudyGroup> getGroups() {
        return groups;
    }
}
