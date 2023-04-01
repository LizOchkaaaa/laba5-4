package org.example.Server.Interfaces;

import org.example.Server.Receiver;
import java.util.ArrayList;

public interface Execute {
    String execute(ArrayList<String> arguments , Receiver worker);
}
