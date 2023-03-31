package org.example.Server.Factores;

import org.example.Server.Models.Coordinates;

public class CoordinatesFactory {
    public Coordinates createCoordinates(String[] args) {
        double x = Double.parseDouble(args[0]);
        Integer y = Integer.parseInt(args[1]);
        Coordinates newCoordinates = new Coordinates(x , y);
        return newCoordinates;
    }
}
