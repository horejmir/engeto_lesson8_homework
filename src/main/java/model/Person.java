package model;

public abstract class Person {
    protected String name;
    protected String surname;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getNameSurname() {
        return name + " " + surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
