package org.example.Server.Validator;

/**Abstract class for validating entered data from the console */
public abstract class ValidateAbstract<E> {
    private String name;

    public ValidateAbstract(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Class<E> getType();
    public abstract boolean validate(String value);
    public abstract boolean validate(String[] value);
}