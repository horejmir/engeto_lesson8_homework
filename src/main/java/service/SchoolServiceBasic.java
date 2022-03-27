package service;

import model.SchoolClass;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class SchoolServiceBasic implements SchoolService {

    protected List<SchoolClass> classes = new ArrayList<>();

    @Override
    public final void addSchoolCLass(SchoolClass schoolClass) {
        classes.add(schoolClass);
    }

    @Override
    public void generateOutput() {

        for( SchoolClass schoolClass:classes) {
            System.out.println(schoolClass.getDescription() + ", " + schoolClass.getTeacher().getNameSurname());
            for(Student student : schoolClass.getStudents()){
                System.out.println(student.getFormattedId() + " " + student.getNameSurname());
            }
            System.out.println("------------------------");
        }

    }
}
