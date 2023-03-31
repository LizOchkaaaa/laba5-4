package org.example.Server.Validator;

import org.example.Server.Models.FormOfEducation;

public class ValidatorFormOfEducation extends ValidateAbstract<FormOfEducation>{

    public ValidatorFormOfEducation() {
        super("StudyGroup.FormOfEducation");
    }

    @Override
    public Class<FormOfEducation> getType() {
        return FormOfEducation.class;
    }

    @Override
    public boolean validate(String value) {
        try {
            var valueEnum = FormOfEducation.valueOf(value);
             if(valueEnum != null) {
                 return true;
             }
             return false;
        }catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public boolean validate(String[] value) {
        return false;
    }
}
