package model;

import java.util.List;

public class SchoolClass {

    private String description;
    private int grade;
    private Teacher teacher;
    private List<Student> students;

    public SchoolClass(String description, int grade, Teacher teacher, List<Student> students) {
        this.description = description;
        this.grade = grade;
        this.teacher = teacher;
        this.students = students;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
