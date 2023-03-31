package org.example.Server.Validator;

public class ValidatorStudyGroup extends ValidateAbstract<String[]>{

    public ValidatorStudyGroup() {
        super("StudyGroup");
    }

//    @Override
//    public boolean validate(String[] variable) {
//        var coordinats = new ValidatorCoordinates();
//        var studentsCount = new ValidatorStudentsCount();
//        var formOfEducation = new ValidatorFormOfEducation();
//        var semester = new ValidatorSemester();
//        var person = new ValidatorPerson();
//
//        if (new ValidateName().validate(variable[0]) && coordinats.validate(coordinats.caster(variable[1])) &&
//        studentsCount.validate(studentsCount.caster(variable[2])) && formOfEducation.validate(formOfEducation.caster(variable[3])) &&
//                semester.validate(semester.caster(variable[4])) && person.validate(person.caster(variable[5]))) {
//            return true;
//        }
//        return false;
//    }

    @Override
    public Class<String[]> getType() {
        return String[].class;
    }

    @Override
    public boolean validate(String value) {
        return false;
    }

    @Override
    public boolean validate(String[] value) {
        try {
            var coordinats = new ValidatorCoordinates();
            var studentsCount = new ValidatorStudentsCount();
            var formOfEducation = new ValidatorFormOfEducation();
            var semester = new ValidatorSemester();
            var person = new ValidatorPerson();

            if (new ValidateName().validate(value[0]) && coordinats.validate(value[1]) &&
                    studentsCount.validate(value[2]) && formOfEducation.validate(value[3]) &&
                    semester.validate(value[4]) && person.validate(value[5])) {
                return true;
            }
            return false;
        }catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
}
