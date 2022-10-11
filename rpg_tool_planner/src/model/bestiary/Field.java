package model.bestiary;

public class Field {
    private String name;
    private FieldOptions[] options = new FieldOptions[3];

    public Field(String name, boolean uniq, boolean req, boolean check, boolean count) {
        if (name.equals(""))
            throw new Error("The field name can't be empty");
        this.name = name;
        int nbOpt = 0;
        if (count & check)
            throw new Error("A field can't be a counter and a checkbox");
        if (uniq)
            options[nbOpt] = FieldOptions.UNIQUE;
        if (req)
            options[nbOpt] = FieldOptions.REQUIRED;
        if (check)
            options[nbOpt] = FieldOptions.CHECKBOX;
        if (count)
            options[nbOpt] = FieldOptions.COUNTER;
        if (nbOpt == 0)
            options[nbOpt] = FieldOptions.NONE;
    }

    public String getName() {
        return name;
    }

    public boolean isUnique() {
        if (options[0] == FieldOptions.NONE)
            return false;
        for (FieldOptions opt : options) {
            if (opt == FieldOptions.UNIQUE)
                return true;
        }
        ;
        return false;
    }

    public boolean isRequired() {
        if (options[0] == FieldOptions.NONE)
            return false;
        for (FieldOptions opt : options) {
            if (opt == FieldOptions.REQUIRED)
                return true;
        }
        ;
        return false;
    }

    public boolean isACheckbox() {
        if (options[0] == FieldOptions.NONE)
            return false;
        for (FieldOptions opt : options) {
            if (opt == FieldOptions.CHECKBOX)
                return true;
        }
        ;
        return false;
    }

    public boolean isACounter() {
        if (options[0] == FieldOptions.NONE)
            return false;
        for (FieldOptions opt : options) {
            if (opt == FieldOptions.COUNTER)
                return true;
        }
        ;
        return false;
    }

    @Override
    public String toString() {
        return "Field " + name;
    }
}
