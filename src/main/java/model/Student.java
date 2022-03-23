package model;

import java.time.LocalDate;

public class Student extends Person {

    private LocalDate dateOfBirth;
    private long id;

    public Student(String name, String surname, LocalDate dateOfBirth, long id) {
        super(name, surname);
        this.dateOfBirth = dateOfBirth;
        this.id = id;
    }

    public String getFormattedId(){
        return "ID"+String.format("%03d", id);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
