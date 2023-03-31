package org.example.Server.Commands;

import org.example.Server.Interfaces.Execute;

public abstract class AbstractCommand implements Execute {
    private String name;
    private String discription;

    private Integer countOfInlineExtraArgs;

    private String fullname;
    private boolean isNeededElementFields;


    public AbstractCommand(String name, String discription , Integer countOfInlineExtraArgs , String fullname , boolean isNeededElementFields) {
        this.name = name;
        this.discription = discription;
        this.countOfInlineExtraArgs = countOfInlineExtraArgs;
        this.fullname = fullname;
        this.isNeededElementFields = isNeededElementFields;
    }

    public Integer getCountOfInlineExtraArgs() {
        return countOfInlineExtraArgs;
    }

    @Override
    public String toString() {
        if(fullname == ""){
            return name + " - " + discription;
        }
        return name + " " + fullname + " - " + discription;
    }

    public String getName() {
        return name;
    }

    public boolean isNeededElementFields() {
        return isNeededElementFields;
    }
}
