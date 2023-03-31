package org.example.Server.Models;
import org.example.Annotation.Complex;
import org.example.Annotation.Date;
import org.example.Server.XmlUtils.DateTimeAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.ZonedDateTime;

@XmlRootElement(name="studyGroup")
public class StudyGroup implements Comparable<StudyGroup>{
    @XmlElement
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @XmlElement
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement
    @Complex
    private Coordinates coordinates; //Поле не может быть null
    @XmlElement
    @XmlJavaTypeAdapter(DateTimeAdapter.class)
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @XmlElement
    private int studentsCount; //Значение поля должно быть больше 0
    @XmlElement
    @Complex
    private FormOfEducation formOfEducation; //Поле не может быть null
    @XmlElement
    @Complex
    private Semester semesterEnum; //Поле может быть null
    @XmlElement
    @Complex
    private Person groupAdmin; //Поле не может быть null


    public StudyGroup(){}
    public StudyGroup(int id, String name, Person groupAdmin, Semester semesterEnum, FormOfEducation formOfEducation, Coordinates coordinates, int studentsCount) {
        this.id = id;
        this.name = name;
        this.creationDate = ZonedDateTime.now();
        this.groupAdmin = groupAdmin;
        this.semesterEnum = semesterEnum;
        this.formOfEducation = formOfEducation;
        this.coordinates = coordinates;
        this.studentsCount = studentsCount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }


    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public Person getPerson() {
        return groupAdmin;
    }

    @Override
    public int compareTo(StudyGroup o) {
        if (o.getName().compareTo(this.name) != 0) return o.getName().compareTo(this.name);
        if (o.getCreationDate().compareTo(this.creationDate) != 0) return o.getCreationDate().compareTo(this.creationDate);
        if (o.getPerson().compareTo(this.groupAdmin) != 0) return o.getPerson().compareTo(this.groupAdmin);
        if (o.getSemesterEnum().compareTo(this.semesterEnum) != 0) return o.getSemesterEnum().compareTo(this.semesterEnum);
        if (o.getFormOfEducation().compareTo(this.formOfEducation) != 0) return o.getFormOfEducation().compareTo(this.formOfEducation);
        if (o.getCoordinates().compareTo(this.coordinates) != 0) return o.getCoordinates().compareTo(this.coordinates);
        if (o.getStudentsCount() - this.studentsCount != 0) return o.getStudentsCount() - this.studentsCount;
        return 0;
    }

    @Override
    public String toString() {
        return "StudyGroup [id=" + id + ", name=" + name + ", coordinates=" + coordinates + ", creationDate="
                + creationDate + ", studentsCount=" + studentsCount + ", formOfEducation=" + formOfEducation
                + ", semesterEnum=" + semesterEnum + ", groupAdmin=" + groupAdmin + "]";
    }


}
