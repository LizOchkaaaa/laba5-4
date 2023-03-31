package org.example.Server;

public class UniqueId {
    private static Integer id;

    public UniqueId() {
        id = 0;
    }

    public static int getNewId() {
        id += 1;
        return id;
    }

    public static int getCurrentID() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
