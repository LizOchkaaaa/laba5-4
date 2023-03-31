package org.example.Server.Models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="coordinates")
public class Coordinates implements Comparable<Coordinates> {
    public Coordinates(){}
    @XmlElement
    private double x; //Значение поля должно быть больше -564
    @XmlElement
    private int y; //Максимальное значение поля: 441

    public Coordinates(double x , int y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    @Override
    public int compareTo(Coordinates o) {
        if (o.getX() - this.x != 0) return (int)(o.getX() - this.x);
        if (o.getY() - this.y != 0) return o.getY() - this.y;
        return 0;
    }
}
