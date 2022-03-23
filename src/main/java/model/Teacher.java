package model;

public class Teacher extends Person {

    private String academicDegree;

    public Teacher(String name, String surname, String academicDegree) {
        super(name, surname);
        this.academicDegree = academicDegree;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }
}
