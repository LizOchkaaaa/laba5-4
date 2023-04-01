package org.example.Server;

import org.example.Server.Factores.StudyGroupFactory;
import org.example.Server.Models.FormOfEducation;
import org.example.Server.Models.StudyGroup;
import org.example.Server.XmlUtils.XmlFileHandler;

import java.io.File;
import java.util.*;

/**Execution class of all commands*/
public class Receiver {

    private final LocalDateBase localDateBase;

    public Receiver(LocalDateBase localDateBase) {
        this.localDateBase = localDateBase;
    }

    public Date getDateOfInitialization() {
        return localDateBase.getDateOfInitialization();
    }

    public Stack<StudyGroup> getMainCollection() {
        return localDateBase.getMainCollection();
    }

    public Date getDateOfLastChange() {
        return localDateBase.getDateOfLastChange();
    }

    public void setDateOfLastChange() {
        localDateBase.setDateOfLastChange(new Date());
    }

    public LocalDateBase getLocalDateBase() {
        return localDateBase;
    }

    public String clearCollection() {
        if (getMainCollection().size() != 0) {
            getMainCollection().clear();
            setDateOfLastChange();
            return "Main collection cleared";
        } else {
            return "There is no elements in main collection";
        }
    }

    public String saveCollection() {
        try {
            if (new XmlFileHandler().save(getMainCollection(), new File("file.xml"))) {
                return "Collection saved successfully";
            } else  {
                return "Faild";
            }
        } catch (Exception e) {
            return "exception";
        }
    }


    public String show(){
        StringBuilder stringBuilder = new StringBuilder();
        for(StudyGroup studyGroup : getMainCollection()) {
            stringBuilder.append(studyGroup.toString() + "\n");
        }
        return stringBuilder.toString();
    }

    public String addNew(ArrayList<String> arguments , Integer id) {
        if (getMainCollection().add(new StudyGroupFactory().createStudyGroup(id,  arguments))) {
            setDateOfLastChange();
            return "Successfully";
        };
        return "Adding new StudyGroup failed.";
    }


    public String addMax(ArrayList<String> arguments , Integer id) {
        StudyGroup studyGroup = new StudyGroupFactory().createStudyGroup(id,  arguments);
        var iter = 0 ;
        for (StudyGroup studyGroup1 : this.getMainCollection() ) {
            if (studyGroup1.compareTo(studyGroup) > 0) {
                iter++;
            }
        }
        getMainCollection().add(studyGroup);
         if (iter == 0) {
             getMainCollection().add(studyGroup);
             setDateOfLastChange();
             return "Successfully";
         }
         return "Element was not added into the main collection. There is at least one element bigger than typed";
    }

    public String printEnum() {
        Stack<FormOfEducation> setOfFormOfEducation = new Stack<>();
        for (StudyGroup group : getMainCollection()) {
            if (!setOfFormOfEducation.contains(group.getFormOfEducation())) {
                setOfFormOfEducation.add(group.getFormOfEducation());
            }
        }
        return setOfFormOfEducation.toString();
    }


    public void remove(StudyGroup group){
        setDateOfLastChange();
        this.getMainCollection().remove(group);
    }



    public String  removeGreater(ArrayList<String> arguments , Integer id) {
        StudyGroup studyGroup = new StudyGroupFactory().createStudyGroup(id,  arguments);
        int countRemoved = 0;
        for (StudyGroup studyGroup1 : this.getMainCollection() ) {
            if (studyGroup1.compareTo(studyGroup) > 0) {
                getMainCollection().remove(studyGroup1);
                countRemoved++;
            }
        }
        if (countRemoved > 0) {
            setDateOfLastChange();
        }
        return  "Successfully removed "  + countRemoved + " StudyGroups";
    }
    public String printEnum(ArrayList<String> arguments) {
        Stack<FormOfEducation> setOfFormOfEducation = new Stack<>();
        for (StudyGroup group : getMainCollection()) {
            if (!setOfFormOfEducation.contains(group.getFormOfEducation())) {
                setOfFormOfEducation.add(group.getFormOfEducation());
            }
        }
        return setOfFormOfEducation.toString();

    }

    public String sumOfStudentsCount() {
        int sumOfStudentsCountValue = 0;
        Stack<StudyGroup> mainCollection = this.getMainCollection();
        for (StudyGroup group : mainCollection) {
            sumOfStudentsCountValue += group.getStudentsCount();
        }
        return "Sum of all StudentsCount in Study Group = " + sumOfStudentsCountValue;
    }

    public String removeID(String idValue) {
        try {
            int id = Integer.parseInt(idValue);
            Stack<StudyGroup> mainCollection = this.getMainCollection();
            for (StudyGroup group : mainCollection) {
                if (group.getId() == id) {
                    this.remove(group);
                    setDateOfLastChange();
                    return "Successfully";
                }
            }
        } catch (NumberFormatException e) {
            return "Failed. You typed wrong id.";
        }
        return "There is no element with that id.";
    }


    public String reorder() {
        var a = getMainCollection();
        if(a.size() != 0) {
            a.sort(StudyGroup::compareTo);
        }
        else {
            return a.toString() + " " + "There are not elements";
        }
        return a.toString();
    }

    public String update(ArrayList<String> arguments , Integer id) {
        StudyGroup studyGroup = new StudyGroupFactory().createStudyGroup(id,  arguments);
        Stack<StudyGroup> stack2 = getMainCollection();
        var iter = 0;
        var success = false;
        for (StudyGroup studyGroup1 : stack2 ) {
            if (studyGroup1.getId() == id) {
                getMainCollection().remove(studyGroup1);
                getMainCollection().add(iter , studyGroup);
                success = true;
            }
            iter++;
        }
        if(!success) {
            return "Element was not updated";
        }
        else {
            return "Element updated successfully";
        }

    }

    public boolean check(ArrayList<String> arguments){
        for (StudyGroup el : getMainCollection()){
            try {
                if(el.getId() == Integer.parseInt(arguments.get(0))) {
                    return true;
                }
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }
}
