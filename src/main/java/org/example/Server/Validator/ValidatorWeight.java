package org.example.Server.Validator;

public class ValidatorWeight extends ValidateAbstract<Integer>{

    public ValidatorWeight() {
        super("StudyGroup.Person.weight");
    }

    @Override
    public Class<Integer> getType() {
        return Integer.class;
    }

    @Override
    public boolean validate(String value) {
        Integer val;
        try {
            val = Integer.parseInt(value);
            if (val != null) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean validate(String[] value) {
        return false;
    }
}
