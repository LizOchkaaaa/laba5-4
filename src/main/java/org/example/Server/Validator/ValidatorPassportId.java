package org.example.Server.Validator;

public class ValidatorPassportId extends ValidateAbstract<String> {

    public ValidatorPassportId() {
        super("StudyGroup.Person.passportID");
    }

    @Override
    public Class<String> getType() {
        return String.class;
    }

    @Override
    public boolean validate(String value) {
        return (value != null && value.trim().length() != 0);
    }

    @Override
    public boolean validate(String[] value) {
        return false;
    }
}