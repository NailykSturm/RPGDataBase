package model.bestiary;

public class Field {
    private String name;
    private boolean uniq;
    private boolean req;
    private boolean check;
    private boolean count;

    public Field(String name, boolean uniq, boolean req, boolean check, boolean count) {
        this.name = name;
        this.uniq = uniq;
        this.req = req;
        this.check = check;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public boolean isUnique() {
        return uniq;
    }

    public boolean isRequired() {
        return req;
    }

    public boolean isACheckbox() {
        return check;
    }

    public boolean isACounter() {
        return count;
    }

    @Override
    public String toString() {
        return "Field " + name;
    }
}
